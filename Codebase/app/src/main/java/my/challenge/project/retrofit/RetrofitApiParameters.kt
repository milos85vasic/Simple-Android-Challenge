package my.challenge.project.retrofit

import android.content.Context
import my.challenge.project.R

data class RetrofitApiParameters(

    val ctx: Context,
    val readTimeoutInSeconds: Long = 10,
    val connectTimeoutInSeconds: Long = 10,
    val endpoint: Int = R.string.retrofit_endpoint
)