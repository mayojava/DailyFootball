package com.android.mayojava.dailyfootball.data.repositories.fourfourtwo

import androidx.paging.DataSource
import arrow.core.getOrDefault
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.base.util.Logger
import com.android.mayojava.dailyfootball.data.entities.FourFourTwoEntity
import com.android.mayojava.dailyfootball.data.mappers.DiffUtil
import io.reactivex.Flowable
import javax.inject.Inject

class FourFourTwoRepository @Inject constructor(private val localDataSource: FourFourTwoLocalDataSource,
                                                private val remoteDataSource: FourFourTwoRemoteDataSource,
                                                private val dispatchers: AppCoroutineDispatchers,
                                                private val logger: Logger) {

    fun observeNews(): Flowable<List<FourFourTwoEntity>> = localDataSource.observeLatestNews()

    fun observeNewsForPaging(): DataSource.Factory<Int, FourFourTwoEntity> = localDataSource.observeNewsForPagination()

    suspend fun getNewsById(id: Long): FourFourTwoEntity = localDataSource.getNewsById(id)

    suspend fun updateSavedNews() {
        val updatedNews = remoteDataSource.fourFourTwoNews()
        if (updatedNews.isSuccess()) {
            val diff = DiffUtil.diff(localDataSource.newsList(), updatedNews.getOrDefault { listOf() })
            localDataSource.insertNews(diff)
        } else {
            updatedNews.fold({ error -> logger.e(error) }, {})
        }
    }
}
