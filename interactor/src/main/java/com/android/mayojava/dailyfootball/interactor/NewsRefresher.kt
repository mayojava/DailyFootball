package com.android.mayojava.dailyfootball.interactor

import com.android.mayojava.dailyfootball.data.daos.LastRefreshTimeDao
import com.android.mayojava.dailyfootball.data.entities.LastRefreshTimeEntity

interface NewsRefresher {

    suspend fun refreshIfOutdated(source: String, lastRefreshTimeDao: LastRefreshTimeDao, operation: suspend () -> Unit) {
        val time = lastRefreshTimeDao.getSourceRefreshTime(source)
        val now = System.currentTimeMillis()

        if (time == 0L || (now-time) >= TEN_MINUTE_MILLIS) {
            operation.invoke()
            lastRefreshTimeDao.insertRefreshTime(LastRefreshTimeEntity(source, now))
        }
    }

    companion object {
        const val TEN_MINUTE_MILLIS = 10 * 60 * 1000
    }
}
