package my.challenge.project.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import my.challenge.project.R
import my.challenge.project.adapter.UserAdapter
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
        DataProvider.obtain(this, dataCallback)
    }

    private fun populateAdapter(data: Data) {

        val emptyView = findViewById<View>(R.id.empty_view)
        val usersView = findViewById<RecyclerView>(R.id.users)
        val linearLayoutManager = LinearLayoutManager(this)

        emptyView.visibility = View.GONE
        usersView.visibility = View.VISIBLE

        usersView.layoutManager = linearLayoutManager
        usersView.adapter = UserAdapter(data)
    }
}