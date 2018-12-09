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

    private val baseUrl = "http://api.football-data.org/v2/"

    fun footballDataService(): FootballDataService {
        return getRetrofit().create(FootballDataService::class.java)
    }

    protected open fun setOkHttpClientDefaults(builder: OkHttpClient.Builder) {
        builder.addInterceptor(HeaderInterceptor(this))
        builder.addInterceptor(TierInterceptor())
    }

    protected open fun moshiBuilder(): Moshi.Builder = Moshi.Builder()

    protected open fun moshi(): Moshi = moshiBuilder().build()

    protected open fun retrofitBuilder(): Retrofit.Builder = Retrofit.Builder()
        .baseUrl(baseUrl)
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
        return chain.proceed(request)
    }
}

private class TierInterceptor: Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalUrl = request.url()
        val url = originalUrl.newBuilder()
            .addQueryParameter("plan", "TIER_ONE")
            .build()
        return chain.proceed(request.newBuilder().url(url).build())
    }
}
