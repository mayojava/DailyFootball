package com.android.mayojava.dailyfootball.news.fourfourtwo

import androidx.lifecycle.ViewModel
import com.android.mayojava.dailyfootball.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class FourFourTwoModule {
    @ContributesAndroidInjector
    internal abstract fun bindsFourFourTwoFragment(): FourFourTwoFragment

    @Binds
    @IntoMap
    @ViewModelKey(FourFourTwoViewModel::class)
    abstract fun bindsFourFourTwoViewModel(viewModel: FourFourTwoViewModel): ViewModel
}
