package com.android.mayojava.dailyfootball.jobs

import androidx.work.ListenableWorker
import androidx.work.Worker
import dagger.MapKey
import dagger.Module
import dagger.android.AndroidInjector
import dagger.multibindings.Multibinds
import java.lang.annotation.RetentionPolicy
import kotlin.reflect.KClass

interface HasWorkerInjector {
    fun workerInjector(): AndroidInjector<ListenableWorker>
}

internal object AndroidWorkerInjector {
    fun inject(worker: ListenableWorker) {
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
    abstract fun workerInjectorFactories(): Map<String, AndroidInjector.Factory<out ListenableWorker>>
}

@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION)
annotation class WorkerKey(val value: KClass<out ListenableWorker>)
