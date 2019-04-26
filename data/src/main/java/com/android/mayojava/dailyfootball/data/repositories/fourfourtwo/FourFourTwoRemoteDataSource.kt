package com.android.mayojava.dailyfootball.data.repositories.fourfourtwo

import arrow.core.Try
import com.android.mayojava.dailyfootball.base.extensions.await
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.data.RetrofitRunner
import com.android.mayojava.dailyfootball.data.entities.FourFourTwoEntity
import com.android.mayojava.dailyfootball.data.mappers.NewsToFourFourTwo
import com.android.mayojava.dailyfootball.data.services.NewsApi
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FourFourTwoRemoteDataSource @Inject constructor(private val retrofitRunner: RetrofitRunner,
                                                      private val newsApi: NewsApi,
                                                      private val dispatchers: AppCoroutineDispatchers): FourFourTwoDataSource {
    override suspend fun fourFourTwoNews(): Try<List<FourFourTwoEntity>> {
        return withContext(dispatchers.io) {
            retrofitRunner.executeForResponse(NewsToFourFourTwo) {
                newsApi.newsApiService().fetch(10, source).await()
            }
        }
    }

    companion object {
        private const val source = "four-four-two"
    }
}
