package com.android.mayojava.dailyfootball.data.services

import okhttp3.Interceptor
import okhttp3.Response

class FootballDataApi(val token: String) {
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