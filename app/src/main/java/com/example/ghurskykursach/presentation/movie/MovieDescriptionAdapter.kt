package com.example.ghurskykursach.presentation.movie

import android.os.Bundle
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
import com.example.ghurskykursach.domain.response_by_id.DocsById
import com.example.ghurskykursach.domain.response_by_id.PersonsById

class MovieDescriptionAdapter(
    private val movieList: List<PersonsById>
) : RecyclerView.Adapter<MovieDescriptionAdapter.MainViewHolder>() {

    companion object {
        var megastatus = false
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MainViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.item_actor, parent, false)
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
        private val position: TextView = itemView.findViewById(R.id.tv_Position)
        private val bundle = Bundle()
        fun bind(item: PersonsById) {
            megastatus = false
            name.text = item.name
            position.text = item.enProfession

            Glide.with(itemView)
                .load(item.photo)
                .placeholder(R.drawable.ic_search)
                .into(avatar)

//            itemView.setOnClickListener {
//                if (megastatus == false) {
//                    megastatus = true
//                    bundle.putInt("ID", item.id)
//                    Navigation.findNavController(itemView)
//                        .navigate(R.id.action_mainFragment_to_movieDescriptionFragment, bundle)
//                }
//            }

        }
    }
}