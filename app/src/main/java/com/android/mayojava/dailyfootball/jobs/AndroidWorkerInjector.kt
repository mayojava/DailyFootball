package com.android.mayojava.dailyfootball.jobs

import androidx.work.Worker
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.Multibinds

interface HasWorkerInjector {
    fun workerInjector(): AndroidInjector<Worker>
}

internal object AndroidWorkerInjector {
    fun inject(worker: Worker) {
        val context = worker.applicationContext
        if (context !is HasWorkerInjector) {
            throw IllegalStateException("${context.javaClass.canonicalName} does not implement " +
                    HasWorkerInjector::class.java.canonicalName
            )
        }

        val workerInjector = (context as HasWorkerInjector).workerInjector()
        workerInjector.inject(worker)
    }
}

@Module
abstract class AndroidWorkerInjectionModule {
    @Multibinds
    abstract fun workerInjectorFactories(): Map<String, AndroidInjector.Factory<out Worker>>
}
