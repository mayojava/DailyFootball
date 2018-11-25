package com.android.mayojava.dailyfootball.data.services

import com.squareup.moshi.Moshi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

open class FootballDataApi(val token: String) {
    private var retrofit: Retrofit? = null
    private var okHttpClient: OkHttpClient? = null

    private val API_URL = "http://api.football-data.org/v2/"

    fun footballDataService(): FootballDataService {
        return getRetrofit().create(FootballDataService::class.java)
    }

    protected open fun setOkHttpClientDefaults(builder: OkHttpClient.Builder) {
        builder.addInterceptor(HeaderInterceptor(this))
    }

    protected open fun moshiBuilder(): Moshi.Builder = Moshi.Builder()

    protected open fun moshi(): Moshi = moshiBuilder().build()

    protected open fun retrofitBuilder(): Retrofit.Builder = Retrofit.Builder()
        .baseUrl(API_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi()))
        .client(okHttpClient())

    private fun okHttpClient(): OkHttpClient {
        if (okHttpClient == null) {
            val builder = OkHttpClient.Builder()
            setOkHttpClientDefaults(builder)
            okHttpClient = builder.build()
        }
        return okHttpClient!!
    }

    private fun getRetrofit(): Retrofit {
        if (retrofit == null) {
            retrofit = retrofitBuilder().build()
        }
        return retrofit!!
    }
}

private class HeaderInterceptor(private val api: FootballDataApi): Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("X-Auth-Token", api.token)
            .build()

        val urlBuilder = request.url().newBuilder()
        urlBuilder.addQueryParameter("plan", "TIER_ONE")
        return chain.proceed(request)
    }

}