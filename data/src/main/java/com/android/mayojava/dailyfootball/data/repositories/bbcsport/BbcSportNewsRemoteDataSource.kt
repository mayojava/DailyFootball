package com.android.mayojava.dailyfootball.data.repositories.bbcsport

import arrow.core.Try
import com.android.mayojava.dailyfootball.base.extensions.await
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.data.RetrofitRunner
import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity
import com.android.mayojava.dailyfootball.data.mappers.NewsToBbcSport
import com.android.mayojava.dailyfootball.data.services.NewsApi
import kotlinx.coroutines.withContext

class BbcSportNewsRemoteDataSource(private val retrofitRunner: RetrofitRunner,
                                   private val newsApi: NewsApi,
                                   private val dispatchers: AppCoroutineDispatchers): BbcSportNewsDataSource {

    override suspend fun getLatestNews(): Try<List<BbcNewsEntity>> {
        return withContext(dispatchers.io) {
            retrofitRunner.executeForResponse(NewsToBbcSport) {
                newsApi.newsApiService().fetch(10, source).await()
            }
        }
    }

    companion object {
        private const val source = "bbc-sport"
    }
}
