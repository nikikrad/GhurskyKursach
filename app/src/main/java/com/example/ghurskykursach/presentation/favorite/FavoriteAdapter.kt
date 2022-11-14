package com.example.ghurskykursach.presentation.favorite

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
import com.example.ghurskykursach.presentation.movie.response.MoviesFirebase

class FavoriteAdapter(
    private val movieList: MutableList<MoviesFirebase>
) : RecyclerView.Adapter<FavoriteAdapter.MainViewHolder>() {

    companion object {
        var megastatus = false
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_films, parent, false)
        return MainViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int = movieList.size

    class MainViewHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.tv_Name)
        private val avatar: ImageView = itemView.findViewById((R.id.iv_Avatar))
        private val backPoster: ImageView = itemView.findViewById(R.id.iv_BackPoster)
        private val bundle = Bundle()
        fun bind(item: MoviesFirebase) {
            megastatus = false

            try{

                Glide.with(itemView)
                    .load(item.poster)
                    .placeholder(R.drawable.ic_search)
                    .into(avatar)

                name.text = item.name

                if(item.backdrop != ""){
                    Glide.with(itemView)
                        .load(item.backdrop)
                        .placeholder(R.drawable.ic_search)
                        .into(backPoster)
                }


            }catch (e:Exception){
                Log.e("TAG", e.localizedMessage.toString() )
            }


            itemView.setOnClickListener {
                if (megastatus == false) {
                    megastatus = true
                    bundle.putInt("ID", item.id.toInt())
                    Navigation.findNavController(itemView)
                        .navigate(R.id.action_favoriteFragment_to_movieDescriptionFragment, bundle)
                }
            }

        }
    }
}