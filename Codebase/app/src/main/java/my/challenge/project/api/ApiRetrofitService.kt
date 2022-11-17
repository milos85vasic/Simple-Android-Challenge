package my.challenge.project.api

import my.challenge.project.common.ObtainParametrized
import my.challenge.project.retrofit.RetrofitApiParameters
import my.challenge.project.retrofit.RetrofitProvider
import retrofit2.Call
import retrofit2.http.GET

interface ApiRetrofitService {

    companion object : ObtainParametrized<ApiRetrofitService, RetrofitApiParameters> {

        override fun obtain(param: RetrofitApiParameters): ApiRetrofitService =
            RetrofitProvider.obtain(param)
                .create(ApiRetrofitService::class.java)
    }

    @GET("SharminSirajudeen/test_resources/posts")
    fun getPosts(): Call<List<Post>>

    @GET("SharminSirajudeen/test_resources/users")
    fun getUsers(): Call<List<User>>
}