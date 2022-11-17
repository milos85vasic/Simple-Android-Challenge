package my.challenge.project.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import my.challenge.project.R

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title: TextView = itemView.findViewById(R.id.title)
    val body: TextView = itemView.findViewById(R.id.body)
}