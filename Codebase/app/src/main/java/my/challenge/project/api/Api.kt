package my.challenge.project.api

import android.content.Context
import com.google.gson.stream.MalformedJsonException
import my.challenge.project.common.ObtainCallback
import my.challenge.project.connectivity.Connectivity
import my.challenge.project.connectivity.ConnectivityCheck
import my.challenge.project.execution.TaskExecutor
import my.challenge.project.retrofit.RetrofitApiParameters
import java.io.IOException

class Api(private val connectivity: ConnectivityCheck = Connectivity()) {

    private val executor = TaskExecutor.instantiate(5)

    fun getUsers(ctx: Context, callback: ObtainCallback<List<User>>) {

        if (connectivity.isNetworkAvailable(ctx)) {

            executor.execute {

                try {

                    val param = RetrofitApiParameters(ctx)

                    val response = ApiRetrofitService.obtain(param)
                        .getUsers()
                        .execute()

                    val body = response.body()

                    if (response.isSuccessful && body != null) {

                        callback.onCompleted(body)

                    } else {

                        val error = IOException("API call was not successful")
                        callback.onFailure(error)
                    }

                } catch (e: IOException) {

                    callback.onFailure(e)

                } catch (e: MalformedJsonException) {

                    callback.onFailure(e)
                }
            }

        } else {

            val error = IllegalStateException("No internet connection")
            callback.onFailure(error)
        }
    }

    fun getPosts(ctx: Context, callback: ObtainCallback<List<Post>>) {

        if (connectivity.isNetworkAvailable(ctx)) {

            executor.execute {

                try {

                    val param = RetrofitApiParameters(ctx)

                    val response = ApiRetrofitService.obtain(param)
                        .getPosts()
                        .execute()

                    val body = response.body()

                    if (response.isSuccessful && body != null) {

                        callback.onCompleted(body)

                    } else {

                        val error = IOException("API call was not successful")
                        callback.onFailure(error)
                    }

                } catch (e: IOException) {

                    callback.onFailure(e)

                } catch (e: MalformedJsonException) {

                    callback.onFailure(e)
                }
            }

        } else {

            val error = IllegalStateException("No internet connection")
            callback.onFailure(error)
        }
    }
}