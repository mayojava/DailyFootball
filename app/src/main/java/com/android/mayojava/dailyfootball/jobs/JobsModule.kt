package com.android.mayojava.dailyfootball.jobs

import androidx.work.ListenableWorker
import dagger.Binds
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap

@Module(
    subcomponents = [
        NewsCleanUpSubcomponent::class
    ]
)
abstract class JobsModule {
    @Binds
    @IntoMap
    @WorkerKey(NewsDbCleanUpWorker::class)
    abstract fun bindNewsCleanUpWorker(builder: NewsCleanUpSubcomponent.Builder): AndroidInjector.Factory<out ListenableWorker>
}
