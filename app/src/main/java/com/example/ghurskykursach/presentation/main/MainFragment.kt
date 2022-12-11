package com.example.ghurskykursach.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ghurskykursach.databinding.FragmentMainBinding
import com.example.ghurskykursach.domain.response.Docs
import org.koin.android.ext.android.inject

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val mainViewModel: MainViewModel by inject()
    private var responseBody: MutableList<Docs> = emptyList<Docs>().toMutableList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        mainViewModel.getResponse()

        mainViewModel.liveData.observe(viewLifecycleOwner) { movies ->
            responseBody.clear()

            movies.docs.forEach {
                if (it.name !== null && it.description !== null){
                    responseBody.add(it)
                }
            }
            val adapter = MainAdapter(responseBody)
            binding.rvMovies.layoutManager =
                LinearLayoutManager(
                    activity?.applicationContext, LinearLayoutManager.VERTICAL, false)
            binding.rvMovies.adapter = adapter
        }


    }

}