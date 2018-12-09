package com.android.mayojava.dailyfootball.interactor

import androidx.paging.DataSource
import io.reactivex.Flowable
import kotlinx.coroutines.channels.ReceiveChannel

interface Interactor<in Param> {
    suspend operator fun invoke(params: Param)
}

interface NoParamsInteractor {
    suspend operator fun invoke()
}

interface PagingInteractor<T> {
    fun dataSourceFactory(): DataSource.Factory<Int, T>
}

abstract class RunnableInteractor<T>: NoParamsInteractor {
    override suspend fun invoke() {
        execute()
    }

    protected abstract suspend fun execute()

    abstract fun observe(): ReceiveChannel<T>
}

abstract class ExecutorInteractor<P: Any, T>: Interactor<P> {
    override suspend fun invoke(params: P) {
        execute(params)
    }

    protected abstract suspend fun execute(params: P)

    abstract fun ReceiveChannel(): Flowable<T>
}

