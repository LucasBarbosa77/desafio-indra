package com.lucas.barbosa.desafioindra.ui.list

import android.content.Context
import android.content.res.TypedArray
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.lucas.barbosa.desafioindra.R
import com.lucas.barbosa.desafioindra.data.local.models.Movie
import com.lucas.barbosa.desafioindra.utils.getProgressBarIndeterminate
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.holder_movie.view.*


class MovieAdapter(private var movies: List<Movie>, private val context: Context) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_movie, parent, false)
        return ViewHolder(
            view
        )
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.movieText.text = movie.title
        Picasso.get()
            .load("http://image.tmdb.org/t/p/w185/" + movie.postPath)
            .placeholder(getProgressBarIndeterminate(context)!!)
            .into(holder.movieImage)
    }

    fun updateData(data: List<Movie>) {
        movies = data
    }

    fun getItemAtPosition(position: Int): Movie {
        return movies[position]
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieImage: ImageView = itemView.image_movie
        val movieText: TextView = itemView.text_movie
    }

}