package my.challenge.project

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import my.challenge.project.adapter.UsersAdapter
import my.challenge.project.api.Api
import my.challenge.project.api.Post
import my.challenge.project.api.User
import my.challenge.project.common.ObtainCallback
import my.challenge.project.provider.Data
import my.challenge.project.provider.DataProvider
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private val dataCallback = object : ObtainCallback<Data> {

        override fun onCompleted(data: Data) {

            if (!isFinishing) {

                Timber.v("Data has been obtained")

                runOnUiThread {

                    populateAdapter(data)
                }
            }
        }

        override fun onFailure(error: Throwable) {

            Timber.e(error)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        DataProvider().obtain(this, dataCallback)
    }

    private fun populateAdapter(data: Data) {

        val usersView = findViewById<RecyclerView>(R.id.users)
        val linearLayoutManager = LinearLayoutManager(this)

        usersView.layoutManager = linearLayoutManager
        usersView.adapter = UsersAdapter(data)
    }
}