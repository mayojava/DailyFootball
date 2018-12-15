package com.android.mayojava.dailyfootball.jobs

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent
interface NewsCleanUpSubcomponent: AndroidInjector<NewsDbCleanUpWorker> {
    @Subcomponent.Builder
    abstract class Builder: AndroidInjector.Builder<NewsDbCleanUpWorker>()
}
