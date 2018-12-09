package com.android.mayojava.dailyfootball

import androidx.work.Worker
import com.android.mayojava.dailyfootball.base.util.Logger
import com.android.mayojava.dailyfootball.baseandroid.TimberLogger
import com.android.mayojava.dailyfootball.injection.DaggerAppComponent
import com.android.mayojava.dailyfootball.jobs.HasWorkerInjector
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class DailyFootballApplication: DaggerApplication() {
//    @Inject lateinit var workerInjector: DispatchingAndroidInjector<Worker>
//
//    override fun workerInjector(): AndroidInjector<Worker> = workerInjector

    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}
