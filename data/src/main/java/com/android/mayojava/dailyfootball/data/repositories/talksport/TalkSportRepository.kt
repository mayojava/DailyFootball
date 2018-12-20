package com.android.mayojava.dailyfootball.data.repositories.talksport

import androidx.paging.DataSource
import arrow.core.getOrDefault
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.base.util.Logger
import com.android.mayojava.dailyfootball.data.entities.TalkSportEntity
import com.android.mayojava.dailyfootball.data.mappers.DiffUtil
import io.reactivex.Flowable
import javax.inject.Inject

class TalkSportRepository @Inject constructor(
    private val localDataSource: TalkSportLocalDataSource,
    private val remoteDataSource: TalkSportRemoteDataSource,
    private val dispatchers: AppCoroutineDispatchers,
    private val logger: Logger) {

    fun observeNews(): Flowable<List<TalkSportEntity>> = localDataSource.observeLatestNews()

    fun observeNewsForPaging(): DataSource.Factory<Int, TalkSportEntity> = localDataSource.observeNewsForPagination()

    suspend fun getNewsById(id: Long): TalkSportEntity = localDataSource.getNewsById(id)

    suspend fun updateTalkSportNews() {
        val response = remoteDataSource.talkSportNews()
        if (response.isSuccess()) {
            val diff = DiffUtil.diff(localDataSource.newsList(), response.getOrDefault { listOf() })
            localDataSource.inserNews(diff)
        } else {
            response.fold({ error -> logger.e(error)}, {})
        }
    }
}
