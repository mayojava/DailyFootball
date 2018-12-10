package com.android.mayojava.dailyfootball.news.bbc

import androidx.lifecycle.ViewModel
import com.android.mayojava.dailyfootball.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class BbcNewsModule {
    @ContributesAndroidInjector
    internal abstract fun bindsBbcNewsFragment(): BbcNewsFragment

    @Binds
    @IntoMap
    @ViewModelKey(BbcNewsViewModel::class)
    abstract fun bindsBbcNewsViewModel(viewModel: BbcNewsViewModel): ViewModel
}
