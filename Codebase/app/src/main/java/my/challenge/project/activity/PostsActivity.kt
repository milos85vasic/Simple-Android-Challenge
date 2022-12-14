package my.challenge.project.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import my.challenge.project.R
import my.challenge.project.adapter.PostAdapter
import my.challenge.project.provider.DataProvider
import timber.log.Timber

class PostsActivity : AppCompatActivity() {

    companion object {

        const val KEY_USER_ID = "user_id"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_posts)

        val userId = intent.getLongExtra(KEY_USER_ID, -1L)
        if (userId <= 0) {

            Timber.e("Invalid user ID")
            finish()

        } else {

            val data = DataProvider.userData
            val posts = data.posts[userId]
            val user = data.userMap[userId]

            if (user == null) {

                Timber.e("No user available")
                finish()
                return
            }

            val image = findViewById<ImageView>(R.id.image)

            Glide.with(image.context)
                .load(user.url)
                .into(image)

            posts?.let {

                Timber.v("Posts count: ${it.size}")

                val postsView = findViewById<RecyclerView>(R.id.posts)
                val linearLayoutManager = LinearLayoutManager(this)

                postsView.visibility = View.VISIBLE
                postsView.layoutManager = linearLayoutManager
                postsView.adapter = PostAdapter(it)
            }
        }
    }
}