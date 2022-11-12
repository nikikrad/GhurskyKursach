package com.example.improvedcrypto.files.data.module

import com.example.animeproject.domain.instance.RetrofitInstance
import com.example.ghurskykursach.domain.ApiService
import com.example.ghurskykursach.presentation.main.MainViewModel
import com.example.ghurskykursach.presentation.main.repository.MainRepository
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    single { MainRepository(get()) }

    viewModel { MainViewModel(get()) }

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