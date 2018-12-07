package com.android.mayojava.dailyfootball.injection

import androidx.lifecycle.ViewModelProvider
import dagger.Module

@Module
internal abstract class ViewModelBuilder {
    internal abstract fun bindViewModelFactory(viewModelFactory: AppViewModelFactory): ViewModelProvider.Factory
}
