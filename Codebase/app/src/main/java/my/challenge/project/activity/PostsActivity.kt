package my.challenge.project.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import my.challenge.project.R
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

            posts?.let {

                Timber.v("Posts count: ${it.size}")
            }
        }
    }
}