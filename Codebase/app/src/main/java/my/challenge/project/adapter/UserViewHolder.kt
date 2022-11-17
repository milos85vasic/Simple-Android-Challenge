package my.challenge.project.adapter

import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import my.challenge.project.R

class UserViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    val root = itemView.findViewById<View>(R.id.item)
    val image = itemView.findViewById<ImageView>(R.id.image)
}