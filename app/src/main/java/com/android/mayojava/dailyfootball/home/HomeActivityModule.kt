package com.android.mayojava.dailyfootball.home

import androidx.lifecycle.ViewModel
import com.android.mayojava.dailyfootball.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class HomeActivityModule {
    @ContributesAndroidInjector(modules = [
        HomeFragmentModule::class
    ])
    internal abstract fun bindsHomeActivity(): HomeActivity

    @Binds
    @IntoMap
    @ViewModelKey(HomeActivityViewModel::class)
    abstract fun bindHomeActivityViewModel(viewModel: HomeActivityViewModel): ViewModel
}
