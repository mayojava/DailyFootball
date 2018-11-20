package com.android.mayojava.dailyfootball.data

import arrow.core.Try
import com.android.mayojava.dailyfootball.base.extensions.bodyOrThrow
import com.android.mayojava.dailyfootball.base.extensions.toException
import com.android.mayojava.dailyfootball.data.mappers.Mapper
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitRunner @Inject constructor() {
    suspend fun <T, E> executeForResponse(mapper: Mapper<T, E>, request: suspend () -> Response<T>): Try<E> {
        return try {
            val response = request()
            if (response.isSuccessful) {
                Try.just(mapper.map(response.bodyOrThrow()))
            } else {
                Try.raise(response.toException())
            }
        } catch (e: Exception) {
            Try.raise(e)
        }
    }
}