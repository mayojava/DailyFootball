package com.android.mayojava.dailyfootball.competitions

import androidx.lifecycle.ViewModel
import com.android.mayojava.dailyfootball.injection.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
internal abstract class SelectCompetitionModule {
    @ContributesAndroidInjector
    internal abstract fun bindsSelectCompetitionFragment(): SelectCompetitionFragment

    @Binds
    @IntoMap
    @ViewModelKey(SelectCompetitionViewModel::class)
    abstract fun bindsSelectCompetitionViewModel(viewModel: SelectCompetitionViewModel): ViewModel
}
