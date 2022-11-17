package my.challenge.project.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import my.challenge.project.R
import my.challenge.project.activity.PostsActivity
import my.challenge.project.provider.Data
import timber.log.Timber

class UserAdapter(private val data: Data) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_user, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user = data.users[position]

        val root = holder.root
        val name = holder.name
        val image = holder.image
        val count = holder.count

        name.text = user.name
        count.text = data.posts[user.userId]?.size.toString()

        root.setOnClickListener {

            Timber.v("Opening user: ${user.userId}")

            val intent = Intent(root.context, PostsActivity::class.java)
            intent.putExtra(PostsActivity.KEY_USER_ID, user.userId)
            root.context.startActivity(intent)
        }

        Glide.with(image.context)
            .load(user.thumbnailUrl)
            .circleCrop()
            .into(image)
    }

    override fun getItemCount() = data.users.size
}