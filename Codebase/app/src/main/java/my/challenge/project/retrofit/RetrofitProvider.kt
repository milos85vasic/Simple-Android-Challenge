package my.challenge.project.retrofit

import my.challenge.project.common.ObtainParametrized
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitProvider : ObtainParametrized<Retrofit, RetrofitApiParameters> {

    override fun obtain(param: RetrofitApiParameters): Retrofit {

        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val ctx = param.ctx.applicationContext
        val readTime = param.readTimeoutInSeconds
        val connTime = param.connectTimeoutInSeconds

        return Retrofit.Builder()
            .baseUrl(ctx.getString(param.endpoint))
            .addConverterFactory(GsonConverterFactory.create())
            .client(

                instantiateOkHttpClient(
                    loggingInterceptor,
                    readTime,
                    connTime
                )
            )
            .build()
    }

    private fun instantiateOkHttpClient(

        loggingInterceptor: HttpLoggingInterceptor,
        readTime: Long,
        connTime: Long

    ): OkHttpClient {

        val builder = OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .readTimeout(readTime, TimeUnit.SECONDS)
            .connectTimeout(connTime, TimeUnit.SECONDS)

        return builder.build()
    }
}