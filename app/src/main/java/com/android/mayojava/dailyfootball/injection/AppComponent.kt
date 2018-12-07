package com.android.mayojava.dailyfootball.injection

import com.android.mayojava.dailyfootball.DailyFootballApplication
import com.android.mayojava.dailyfootball.data.services.ServicesModule
import com.android.mayojava.dailyfootball.dataandroid.DatabaseModule
import com.android.mayojava.dailyfootball.home.HomeActivityModule
import com.android.mayojava.dailyfootball.jobs.AndroidWorkerInjectionModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    AndroidSupportInjectionModule::class,
    HomeActivityModule::class,
    DatabaseModule::class,
    NetworkModule::class,
    ServicesModule::class,
    ViewModelBuilder::class
])
interface AppComponent: AndroidInjector<DailyFootballApplication> {
    @Component.Builder
    abstract class Builder: AndroidInjector.Builder<DailyFootballApplication>()
}
