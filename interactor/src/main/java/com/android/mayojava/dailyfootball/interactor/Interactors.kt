package com.android.mayojava.dailyfootball.interactor

import androidx.paging.DataSource
import io.reactivex.Flowable

interface Interactor<in Param> {
    suspend operator fun invoke(params: Param)
}

interface PagingInteractor<T> {
    fun dataSourceFactory(): DataSource.Factory<Int, T>
}

abstract class BaseInteractor<P: Any, T>: Interactor<P> {
    override suspend fun invoke(params: P) {
        execute(params)
    }

    protected abstract suspend fun execute(params: P)

    protected abstract fun createObservable(): Flowable<T>
}

class None
