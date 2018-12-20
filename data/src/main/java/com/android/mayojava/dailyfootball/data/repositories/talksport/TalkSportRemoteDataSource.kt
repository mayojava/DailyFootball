package com.android.mayojava.dailyfootball.data.repositories.talksport

import arrow.core.Try
import com.android.mayojava.dailyfootball.base.extensions.await
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.data.RetrofitRunner
import com.android.mayojava.dailyfootball.data.entities.TalkSportEntity
import com.android.mayojava.dailyfootball.data.mappers.NewsToTalkSport
import com.android.mayojava.dailyfootball.data.services.NewsApi
import kotlinx.coroutines.withContext
import javax.inject.Inject

class TalkSportRemoteDataSource @Inject constructor(private val retrofitRunner: RetrofitRunner,
                                                    private val newsApi: NewsApi,
                                                    private val dispatchers: AppCoroutineDispatchers): TalkSportDataSource{

    override suspend fun talkSportNews(): Try<List<TalkSportEntity>> {
        return withContext(dispatchers.io) {
            retrofitRunner.executeForResponse(NewsToTalkSport) {
                newsApi.newsApiService().fetch(10, source).await()
            }
        }
    }

    companion object {
        private const val source = "talksport"
    }
}
