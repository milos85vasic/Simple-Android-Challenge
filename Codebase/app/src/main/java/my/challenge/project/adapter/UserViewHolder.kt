package my.challenge.project.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import my.challenge.project.R

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val root: View = itemView.findViewById(R.id.item)
    val name: TextView = itemView.findViewById(R.id.name)
    val count: TextView = itemView.findViewById(R.id.count)
    val image: ImageView = itemView.findViewById(R.id.image)
}