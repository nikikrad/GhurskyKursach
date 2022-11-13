package com.example.improvedcrypto.files.data.module

import com.example.animeproject.domain.instance.RetrofitInstance
import com.example.ghurskykursach.domain.ApiService
import com.example.ghurskykursach.presentation.main.MainViewModel
import com.example.ghurskykursach.presentation.main.repository.MainRepository
import com.example.ghurskykursach.presentation.movie.MovieDescriptionViewModel
import com.example.ghurskykursach.presentation.movie.repository.MovieRepository
import com.example.ghurskykursach.presentation.search.SearchViewModel
import com.example.ghurskykursach.presentation.search.repository.SearchRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { MainRepository(get()) }

    viewModel { MainViewModel(get()) }

    viewModel { MovieDescriptionViewModel(get())}

    single {MovieRepository(get())}

    single{SearchRepository(get())}

    viewModel{SearchViewModel(get())}

    fun provideFirebaseAuth(): FirebaseAuth{
        return FirebaseAuth.getInstance()
    }
    fun provideFirebaseDatabase(): DatabaseReference{
        return Firebase.database.reference
    }

//    single { FavoriteRepository(get()) }
//
//    viewModel { FavoriteViewModel(get()) }
}

val retrofitModule = module{

    fun provideRetrofit(): ApiService {
        return RetrofitInstance.getRetrofitInstance().create(ApiService::class.java)
    }

    single { provideRetrofit() }
}