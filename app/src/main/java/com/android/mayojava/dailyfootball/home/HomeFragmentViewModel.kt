package com.android.mayojava.dailyfootball.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.mayojava.dailyfootball.base.BaseViewModel
import com.android.mayojava.dailyfootball.competitions.CompetitionsUIModel
import com.android.mayojava.dailyfootball.interactor.CompetitionsInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeFragmentViewModel @Inject constructor(private val competitionsInteractor: CompetitionsInteractor): BaseViewModel() {
    private val _competitions: MutableLiveData<List<CompetitionsUIModel>>
    val competitions: LiveData<List<CompetitionsUIModel>>
        get() = _competitions

    init {
        launch {
            competitionsInteractor()
            competitionsInteractor.cr
        }
    }

    fun observe() {

    }
}
