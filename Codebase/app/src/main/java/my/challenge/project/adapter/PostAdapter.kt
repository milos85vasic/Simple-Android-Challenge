package my.challenge.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import my.challenge.project.R
import my.challenge.project.api.Post

class PostAdapter(private val data: List<Post>) : RecyclerView.Adapter<PostViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_post, parent, false)

        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {

        val post = data[position]

        val body = holder.body
        val title = holder.title

        body.text = post.body
        title.text = post.title
    }

    override fun getItemCount() = data.size
}