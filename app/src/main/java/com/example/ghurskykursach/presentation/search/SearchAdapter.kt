package com.example.ghurskykursach.presentation.search

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ghurskykursach.R
import com.example.ghurskykursach.domain.response.Docs
import com.example.ghurskykursach.presentation.main.MainAdapter

class SearchAdapter(
    private val movieList: List<Docs>
) : RecyclerView.Adapter<SearchAdapter.MainViewHolder>() {

    companion object {
        var megastatus = false
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_search_movies, parent, false)
        return MainViewHolder(view)
    }

    //    var i = 0;
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
//        if(movieList[i].name !== null ){
        holder.bind(movieList[position])
//        }
//        i++

    }

    override fun getItemCount(): Int = movieList.size

    class MainViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.tv_Name)
        private val avatar: ImageView = itemView.findViewById((R.id.iv_Avatar))
        private val rating: TextView = itemView.findViewById(R.id.tv_Rating)
        private val alterName: TextView = itemView.findViewById(R.id.tv_AlternativeName)
        private val year: TextView = itemView.findViewById(R.id.tv_Year)
        private val bundle = Bundle()
        fun bind(item: Docs) {
            megastatus = false

            try {
                Glide.with(itemView)
                    .load(item.poster.url)
                    .placeholder(R.drawable.ic_search)
                    .into(avatar)

                rating.text = item.rating.kp.toString()
                alterName.text = item.alternativeName
                year.text = item.year.toString()

                name.text = item.name

            } catch (e: Exception) {
                Log.e("TAG", e.localizedMessage.toString())
            }

            itemView.setOnClickListener {
                if (megastatus == false) {
                    megastatus = true
                    bundle.putInt("ID", item.id)
                    Navigation.findNavController(itemView)
                        .navigate(R.id.action_searchFragment_to_movieDescriptionFragment, bundle)
                }
            }
        }
    }
}