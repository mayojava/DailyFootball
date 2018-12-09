package com.android.mayojava.dailyfootball.data.repositories.competition

import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.data.entities.CompetitionsEntity
import io.reactivex.Flowable
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CompetitionsRepository @Inject constructor(
    private val localDataSource: CompetitionsLocalDataSource,
    private val remoteDataSource: CompetitionsRemoteDataSource,
    private val dispatchers: AppCoroutineDispatchers) {

    fun observeCompetitions(): Flowable<List<CompetitionsEntity>> = localDataSource.observeCompetitions()

    suspend fun fetchCompetitions() {
        val result = remoteDataSource.getCompetitions()
        if (result.isSuccess()) {
            withContext(dispatchers.computation) {
                result.toEither().fold(
                    { /** log throwable **/ },
                    {
                        if (it.isNotEmpty()) {
                            localDataSource.insert(it)
                        }
                    }
                )
            }
        }
    }
}
