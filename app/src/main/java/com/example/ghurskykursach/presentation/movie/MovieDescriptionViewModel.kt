package com.example.ghurskykursach.presentation.movie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ghurskykursach.domain.response_by_id.DocsById
import com.example.ghurskykursach.presentation.movie.comments_model.Comments
import com.example.ghurskykursach.presentation.movie.repository.MovieRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieDescriptionViewModel(private val movieRepository: MovieRepository): ViewModel() {

    val liveData: MutableLiveData<DocsById> = MutableLiveData()

    fun getResponse( id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try{
                liveData.postValue(movieRepository.getMovieById(id))
            }catch (e:Exception){
                Log.e("Error: ", e.toString())
            }
        }
    }

    fun sendComment(commentId: String, id: String, comment:String){
        var auth = FirebaseAuth.getInstance()
        var database = Firebase.database.reference
        viewModelScope.launch(Dispatchers.IO) {
            database.child("Comments").child(id).child(commentId).setValue(Comments(commentId, id, auth.currentUser?.email.toString(), comment))
        }

    }

    var commentsList: MutableLiveData<MutableList<Comments>> = MutableLiveData()

    fun processingData(id: String){
        var database = Firebase.database.reference
        var tempCommList: MutableList<Comments> = emptyList<Comments>().toMutableList()
        viewModelScope.launch(Dispatchers.IO) {
//            status.postValue(false)
            database.child("Comments").child(id)
                .get()
                .addOnSuccessListener {movieId->
                    movieId.children.forEach { comments ->
                        tempCommList.add(Comments(
                            comments.child("comment_id").value.toString(),
                            comments.child("movie_id").value.toString(),
                            comments.child("user_name").value.toString(),
                            comments.child("comment").value.toString()
                        ))
                    }
                    commentsList.postValue(tempCommList)
                }
        }

    }
}