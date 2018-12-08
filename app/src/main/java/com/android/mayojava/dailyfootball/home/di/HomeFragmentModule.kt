package com.android.mayojava.dailyfootball.home.di

import androidx.lifecycle.ViewModel
import com.android.mayojava.dailyfootball.home.HomeFragment
import com.android.mayojava.dailyfootball.home.HomeFragmentViewModel
import com.android.mayojava.dailyfootball.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class HomeFragmentModule {
    @ContributesAndroidInjector
    internal abstract fun bindsHomeFragment(): HomeFragment

    @Binds
    @IntoMap
    @ViewModelKey(HomeFragmentViewModel::class)
    abstract fun bindsHomeFragmentViewModel(viewModel: HomeFragmentViewModel): ViewModel
}
