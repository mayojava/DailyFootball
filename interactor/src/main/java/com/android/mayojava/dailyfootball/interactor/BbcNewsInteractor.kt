package com.android.mayojava.dailyfootball.interactor

import androidx.paging.DataSource
import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity
import com.android.mayojava.dailyfootball.data.repositories.bbcsport.BbcSportNewsRepository
import io.reactivex.Flowable
import javax.inject.Inject

class BbcNewsInteractor @Inject constructor(private val bbcSportNewsRepository: BbcSportNewsRepository): PagingInteractor<BbcNewsEntity>, RunnableInteractor<BbcNewsEntity>() {

    override fun dataSourceFactory(): DataSource.Factory<Int, BbcNewsEntity> = bbcSportNewsRepository.observeNewsForPaging()

    override suspend fun execute() = bbcSportNewsRepository.fetchNewsUpdate()

    override fun createObservable(): Flowable<BbcNewsEntity> {
        return bbcSportNewsRepository.observeNews()
    }
}
