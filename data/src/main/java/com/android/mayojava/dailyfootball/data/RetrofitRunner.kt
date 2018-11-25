package com.android.mayojava.dailyfootball.data

import arrow.core.Try
import com.android.mayojava.dailyfootball.data.mappers.Mapper
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitRunner @Inject constructor() {
    suspend fun <T, E> executeForResponse(mapper: Mapper<T, E>, request: suspend () -> Try<T>): Try<E> {
        return try {
            request().map { mapper.map(it) }
        } catch (throwable: Throwable) {
            Try.raise<Nothing>(throwable)
        }
    }
}
