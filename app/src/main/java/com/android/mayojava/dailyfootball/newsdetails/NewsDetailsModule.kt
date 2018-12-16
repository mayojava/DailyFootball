package com.android.mayojava.dailyfootball.newsdetails

import androidx.lifecycle.ViewModel
import com.android.mayojava.dailyfootball.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class NewsDetailsModule {
    @ContributesAndroidInjector
    internal abstract fun bindsNewsDetailsFragment(): NewsDetailsFragment

    @Binds
    @IntoMap
    @ViewModelKey(NewsDetailsViewModel::class)
    abstract fun bindsNewsDetailsViewModel(viewModel: NewsDetailsViewModel): ViewModel
}
