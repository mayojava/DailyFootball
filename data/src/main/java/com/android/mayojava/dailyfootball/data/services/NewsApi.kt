package com.android.mayojava.dailyfootball.data.services

import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class NewsApi constructor(val apiKey: String) {
    private var retrofit: Retrofit? = null
    private var okHttpClient: OkHttpClient? = null

    private val API_URL = "https://newsapi.org/v2/"

    fun newsApiService(): NewsService {
        return getRetrofit().create(NewsService::class.java)
    }

    protected open fun setOkHttpClientDefaults(builder: OkHttpClient.Builder) {
        builder.addInterceptor(AuthInterceptor(this))
    }

    protected open fun moshiBuilder(): Moshi.Builder = Moshi.Builder()

    protected open fun moshi(): Moshi = moshiBuilder().build()

    protected open fun retrofitBuilder(): Retrofit.Builder = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi()))
        .client(okHttpClient())

    private fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = retrofitBuilder().build()
        }
        return retrofit!!
    }

    private fun okHttpClient(): OkHttpClient {
        if (okHttpClient == null) {
            val builder = OkHttpClient.Builder()
            setOkHttpClientDefaults(builder)
            okHttpClient = builder.build()
        }
        return okHttpClient!!
    }
}

private class AuthInterceptor(private val newsApi: NewsApi): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val urlBuilder = request.url().newBuilder()
        urlBuilder.setQueryParameter("apiKey", newsApi.apiKey)
        return chain.proceed(request)
    }

}