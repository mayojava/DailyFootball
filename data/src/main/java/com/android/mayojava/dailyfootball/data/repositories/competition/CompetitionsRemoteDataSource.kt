package com.android.mayojava.dailyfootball.data.repositories.competition

import arrow.core.Try
import com.android.mayojava.dailyfootball.base.extensions.await
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.data.RetrofitRunner
import com.android.mayojava.dailyfootball.data.entities.CompetitionsEntity
import com.android.mayojava.dailyfootball.data.mappers.CompetitionsToDbEntity
import com.android.mayojava.dailyfootball.data.services.FootballDataApi
import kotlinx.coroutines.withContext

class CompetitionsRemoteDataSource constructor(
    private val retrofitRunner: RetrofitRunner,
    private val footballDataApi: FootballDataApi,
    private val dispatchers: AppCoroutineDispatchers): CompetitionsDataSource {

    override suspend fun getCompetitions(): Try<List<CompetitionsEntity>> {
        return withContext(dispatchers.io) {
            retrofitRunner.executeForResponse(CompetitionsToDbEntity) {
                footballDataApi.footballDataService().competitions().await()
            }
        }
    }
}
