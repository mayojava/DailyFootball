package com.android.mayojava.dailyfootball.jobs

import android.annotation.SuppressLint
import androidx.work.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class NewsNightlyCleanUp @Inject constructor(private val workManager: WorkManager) {
    @SuppressLint("NewApi")
    fun setupNewsNightlyCleanup() {
        val newsDailyCleanUpRequest = PeriodicWorkRequest.Builder(
            NewsDbCleanUpWorker::class.java, 24, TimeUnit.HOURS)
            .setConstraints(Constraints.Builder()
                .setRequiredNetworkType(NetworkType.CONNECTED)
                .setRequiresDeviceIdle(true)
                .build())
            .build()

        workManager.enqueueUniquePeriodicWork(
            NewsDbCleanUpWorker.TAG, ExistingPeriodicWorkPolicy.REPLACE, newsDailyCleanUpRequest)
    }
}
