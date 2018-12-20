package com.android.mayojava.dailyfootball.jobs

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.Result
import androidx.work.WorkerParameters
import com.android.mayojava.dailyfootball.data.repositories.bbcsport.BbcSportNewsLocalDataSource
import com.android.mayojava.dailyfootball.data.repositories.talksport.TalkSportLocalDataSource
import javax.inject.Inject

class NewsDbCleanUpWorker(context: Context, params: WorkerParameters): CoroutineWorker(context, params) {

    @Inject lateinit var bbcSportNewsLocalDataSource: BbcSportNewsLocalDataSource
    @Inject lateinit var talkSportLocalDataSource: TalkSportLocalDataSource

    override suspend fun doWork(): Result {
        AndroidWorkerInjector.inject(this)
        
        bbcSportNewsLocalDataSource.deleteAllNews()
        talkSportLocalDataSource.deleteAllNews()

        return Result.success()
    }

    companion object {
        const val TAG = "periodic_news_cleanup"
    }
}
