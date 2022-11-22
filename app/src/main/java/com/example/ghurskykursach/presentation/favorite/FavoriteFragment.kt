package com.example.ghurskykursach.presentation.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ghurskykursach.databinding.FragmentFavoriteBinding
import com.example.ghurskykursach.domain.response.Docs
import com.example.ghurskykursach.presentation.movie.response.MoviesFirebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class FavoriteFragment : Fragment() {


    private lateinit var binding: FragmentFavoriteBinding
    lateinit var auth: FirebaseAuth
    lateinit var database: DatabaseReference

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        auth = FirebaseAuth.getInstance()
        database = Firebase.database.reference
        if (auth.currentUser == null) {
            binding.rvMovies.isVisible = false
        } else {
            binding.rvMovies.isVisible = true
            processDataFromDatabase()
        }
    }

    private var movieList: MutableList<MoviesFirebase> =
        emptyList<MoviesFirebase>().toMutableList()
    private lateinit var adapter: FavoriteAdapter

    private fun processDataFromDatabase() {
        movieList.clear()
        database.child(auth.currentUser?.email.toString().substringBefore("@")).get()
            .addOnSuccessListener { animeId ->
                animeId.children.forEach { aboutAnime ->
                    movieList.add(
                        MoviesFirebase(
                            aboutAnime.child("id").value.toString(),
                            aboutAnime.child("name").value.toString(),
                            aboutAnime.child("poster").value.toString(),
                            aboutAnime.child("backdrop").value.toString()
                        )
                    )
                }

                adapter = FavoriteAdapter(movieList)
                val unWatchedLinearLayoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
                unWatchedLinearLayoutManager.reverseLayout = true
                unWatchedLinearLayoutManager.stackFromEnd = true
                binding.rvMovies.layoutManager = unWatchedLinearLayoutManager
                binding.rvMovies.adapter = adapter
            }
    }

}