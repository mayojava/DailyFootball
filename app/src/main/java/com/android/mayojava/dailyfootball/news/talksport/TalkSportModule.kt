package com.android.mayojava.dailyfootball.news.talksport

import androidx.lifecycle.ViewModel
import com.android.mayojava.dailyfootball.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class TalkSportModule {
    @ContributesAndroidInjector
    internal abstract fun bindsTalkSportFragment(): TalkSportFragment

    @Binds
    @IntoMap
    @ViewModelKey(TalkSportViewModel::class)
    abstract fun bindTalkSportViewModel(viewModel: TalkSportViewModel): ViewModel
}
