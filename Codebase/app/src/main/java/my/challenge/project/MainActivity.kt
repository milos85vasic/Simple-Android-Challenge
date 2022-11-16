package my.challenge.project

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import my.challenge.project.api.Api
import my.challenge.project.api.Post
import my.challenge.project.api.User
import my.challenge.project.common.ObtainCallback
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        val api = Api()

        api.getPosts(this, object : ObtainCallback<List<Post>> {

            override fun onCompleted(data: List<Post>) {

                Timber.v("Posts: $data")
            }

            override fun onFailure(error: Throwable) = Timber.e(error)
        })

        api.getUsers(this, object : ObtainCallback<List<User>> {

            override fun onCompleted(data: List<User>) {

                Timber.v("Users: $data")
            }

            override fun onFailure(error: Throwable) = Timber.e(error)
        })
    }
}