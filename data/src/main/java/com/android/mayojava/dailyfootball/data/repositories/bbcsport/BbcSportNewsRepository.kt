package com.android.mayojava.dailyfootball.data.repositories.bbcsport

import androidx.paging.DataSource
import arrow.core.Either
import arrow.core.Try
import arrow.core.getOrDefault
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity
import com.android.mayojava.dailyfootball.data.mappers.DiffUtil
import io.reactivex.Flowable
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BbcSportNewsRepository @Inject constructor(
    private val localNewsStore: BbcSportNewsLocalDataSource,
    private val remoteBbcNewsSource: BbcSportNewsRemoteDataSource,
    private val dispatchers: AppCoroutineDispatchers) {

    fun observeNews(): Flowable<List<BbcNewsEntity>> = localNewsStore.observeNews()

    fun observeNewsForPaging(): DataSource.Factory<Int, BbcNewsEntity> = localNewsStore.observeForPagination()

    suspend fun fetchNewsUpdate() {
        val result = remoteBbcNewsSource.getLatestNews()
        if (result.isSuccess()) {
            withContext(dispatchers.computation) {
                val oldItems = localNewsStore.newsList()
                val newItems = result.getOrDefault { listOf() }
                localNewsStore.insertNews(DiffUtil.diff(oldItems, newItems))
            }
        }
    }

    suspend fun fetchNewsObserveResponse(): Either<Throwable, List<BbcNewsEntity>> {
        val result = remoteBbcNewsSource.getLatestNews()
        if (result.isSuccess()) {
            withContext(dispatchers.computation) {
                saveInDb(result)
            }
        }
        return result.toEither()
    }

    private fun saveInDb(result: Try<List<BbcNewsEntity>>) {
        val news = result.getOrDefault { listOf() }
        if (news.isNotEmpty()) {
            localNewsStore.deleteAllAndInsert(news)
        }
    }
}
