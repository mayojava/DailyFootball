package com.android.mayojava.dailyfootball.data.services

import com.android.mayojava.dailyfootball.data.responseentities.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {
    /**
     * entry point to news API
     * fetches news from bbc-sport, talksport, football-italia, the-sport-bible, four-four-two
     */
    @GET("top-headlines")
    fun fetch(
        @Query("pageSize") pageSize: Int,
        @Query("sources") source: String
    ): Call<News>
}
