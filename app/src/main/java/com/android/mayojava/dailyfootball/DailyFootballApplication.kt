package com.android.mayojava.dailyfootball

import androidx.work.ListenableWorker
import com.android.mayojava.dailyfootball.base.util.Logger
import com.android.mayojava.dailyfootball.baseandroid.TimberLogger
import com.android.mayojava.dailyfootball.injection.DaggerAppComponent
import com.android.mayojava.dailyfootball.jobs.HasWorkerInjector
import com.android.mayojava.dailyfootball.jobs.NewsNightlyCleanUp
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class DailyFootballApplication: DaggerApplication(), HasWorkerInjector {

    @Inject lateinit var workerInjector: DispatchingAndroidInjector<ListenableWorker>
    @Inject lateinit var logger: Logger
    @Inject lateinit var newsNightlyCleanUp: NewsNightlyCleanUp

    override fun workerInjector(): AndroidInjector<ListenableWorker> = workerInjector


    override fun onCreate() {
        super.onCreate()
        (logger as TimberLogger).setup(BuildConfig.DEBUG)
        newsNightlyCleanUp.setupNewsNightlyCleanup()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}
