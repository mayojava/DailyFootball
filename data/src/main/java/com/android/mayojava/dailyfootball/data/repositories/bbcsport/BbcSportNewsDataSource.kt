package com.android.mayojava.dailyfootball.data.repositories.bbcsport

import arrow.core.Try
import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity

interface BbcSportNewsDataSource {
    suspend fun getLatestNews(): Try<List<BbcNewsEntity>>
}
