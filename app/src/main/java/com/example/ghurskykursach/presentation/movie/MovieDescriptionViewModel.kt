package com.example.ghurskykursach.presentation.movie

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ghurskykursach.domain.response.Films
import com.example.ghurskykursach.domain.response_by_id.DocsById
import com.example.ghurskykursach.domain.response_by_id.FilmsById
import com.example.ghurskykursach.presentation.main.repository.MainRepository
import com.example.ghurskykursach.presentation.movie.repository.MovieRepository
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
}