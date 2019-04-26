package com.android.mayojava.dailyfootball.interactor

import androidx.paging.DataSource
import com.android.mayojava.dailyfootball.data.NewsSource
import com.android.mayojava.dailyfootball.data.daos.LastRefreshTimeDao
import com.android.mayojava.dailyfootball.data.entities.FourFourTwoEntity
import com.android.mayojava.dailyfootball.data.repositories.fourfourtwo.FourFourTwoRepository
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.reactive.openSubscription
import javax.inject.Inject

class FourFourTwoInteractor @Inject constructor(
    private val fourFourTwoRepository: FourFourTwoRepository,
    private val lastRefreshTimeDao: LastRefreshTimeDao) : PagingInteractor<FourFourTwoEntity>, RunnableInteractor<List<FourFourTwoEntity>>(), NewsRefresher {

    override fun dataSourceFactory(): DataSource.Factory<Int, FourFourTwoEntity> = fourFourTwoRepository.observeNewsForPaging()

    override suspend fun execute() {
        refreshIfOutdated(NewsSource.fourfourtwo, lastRefreshTimeDao) {
            fourFourTwoRepository.updateSavedNews()
        }
    }

    override fun observe(): ReceiveChannel<List<FourFourTwoEntity>> = fourFourTwoRepository.observeNews().openSubscription()

    suspend fun getNewsById(newsId: Long): FourFourTwoEntity = fourFourTwoRepository.getNewsById(newsId)
}
