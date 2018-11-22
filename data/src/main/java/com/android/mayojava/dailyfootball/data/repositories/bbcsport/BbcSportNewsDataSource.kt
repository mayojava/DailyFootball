package com.android.mayojava.dailyfootball.data.repositories.bbcsport

import arrow.core.Try
import com.android.mayojava.dailyfootball.data.responseentities.News

interface BbcSportNewsDataSource {
    suspend fun getLatestNews(): Try<News>
}