package com.android.mayojava.dailyfootball.home.di

import androidx.lifecycle.ViewModel
import com.android.mayojava.dailyfootball.competitions.SelectCompetitionModule
import com.android.mayojava.dailyfootball.home.HomeActivity
import com.android.mayojava.dailyfootball.home.HomeActivityViewModel
import com.android.mayojava.dailyfootball.injection.ViewModelKey
import com.android.mayojava.dailyfootball.news.bbc.BbcNewsModule
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class HomeActivityModule {
    @ContributesAndroidInjector(modules = [
        HomeFragmentModule::class,
        SelectCompetitionModule::class,
        BbcNewsModule::class
    ])
    internal abstract fun bindsHomeActivity(): HomeActivity

    @Binds
    @IntoMap
    @ViewModelKey(HomeActivityViewModel::class)
    abstract fun bindHomeActivityViewModel(viewModel: HomeActivityViewModel): ViewModel
}
