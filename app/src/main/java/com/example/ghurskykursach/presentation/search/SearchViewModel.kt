package com.example.ghurskykursach.presentation.search

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ghurskykursach.domain.response.Films
import com.example.ghurskykursach.presentation.search.repository.SearchRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel(private val searchRepository: SearchRepository): ViewModel() {


    val liveData: MutableLiveData<Films> = MutableLiveData()

    fun getResponse(name: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try{
                liveData.postValue(searchRepository.getMovieByName(name))
            }catch (e:Exception){
                Log.e("Error: ", e.toString())
            }
        }
    }

}