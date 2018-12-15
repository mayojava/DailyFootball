package com.android.mayojava.dailyfootball.jobs

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Result
import androidx.work.WorkerParameters
import com.android.mayojava.dailyfootball.data.repositories.bbcsport.BbcSportNewsLocalDataSource
import javax.inject.Inject

class NewsDbCleanUpWorker(context: Context, params: WorkerParameters): CoroutineWorker(context, params) {

    @Inject lateinit var bbcSportNewsLocalDataSource: BbcSportNewsLocalDataSource
    /**
     * TODO inject local dao for other news source repository and call delete to clear
     */

    override suspend fun doWork(): Result {
        bbcSportNewsLocalDataSource.deleteAllNews()
        return Result.success()
    }

    companion object {
        const val TAG = "periodic_news_cleanup"
    }
}
