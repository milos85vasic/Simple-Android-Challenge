package my.challenge.project.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import my.challenge.project.R
import my.challenge.project.provider.Data
import timber.log.Timber

class UsersAdapter(private val data: Data) : RecyclerView.Adapter<UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_user, parent, false)

        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {

        val user = data.users[position]

        val root = holder.root
        val image = holder.image

        root.setOnClickListener {

            Timber.v("Opening user: ${user.userId}")
        }

        Glide.with(image.context)
            .load(user.thumbnailUrl)
            .circleCrop()
            .into(image)
    }

    override fun getItemCount() = data.users.size
}