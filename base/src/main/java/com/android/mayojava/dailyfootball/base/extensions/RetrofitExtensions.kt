package com.android.mayojava.dailyfootball.base.extensions

import arrow.core.Try
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

suspend fun <T> Call<T>.await(): Try<T> = suspendCancellableCoroutine {
    enqueue(object: Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            it.resumeWithException(t)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            if (response.isSuccessful) {
                it.resume(Try.just(response.body()!!))
            } else {
                it.resumeWithException(response.toException())
            }
        }
    })
}

fun <T> Response<T>.toException() = HttpException(this)
