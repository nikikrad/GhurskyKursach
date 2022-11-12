package com.example.ghurskykursach.presentation.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ghurskykursach.databinding.FragmentMainBinding
import org.koin.android.ext.android.inject

class MainFragment : Fragment(){

    private lateinit var binding: FragmentMainBinding
    private val mainViewModel: MainViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        mainViewModel.getResponse("HB6B6RM-2VC45QY-KY7D7BE-GRVSZX4", "Книга Илая")

//        responseBody.clear()
        mainViewModel.liveData.observe(viewLifecycleOwner) {
            Log.e("TAG", it.toString())
//            binding.pbProgressBar.isVisible = it.isEmpty()
//            val adapter = MainAdapter(it)
//            binding.rvCoins.layoutManager =
//                LinearLayoutManager(
//                    activity?.applicationContext,
//                    LinearLayoutManager.VERTICAL,
//                    false
//                )
//            binding.rvCoins.adapter = adapter
        }
    }

}