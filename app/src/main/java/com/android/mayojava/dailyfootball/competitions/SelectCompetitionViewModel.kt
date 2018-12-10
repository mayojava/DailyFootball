package com.android.mayojava.dailyfootball.competitions

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.mayojava.dailyfootball.base.BaseViewModel
import com.android.mayojava.dailyfootball.interactor.CompetitionsInteractor
import kotlinx.coroutines.launch
import javax.inject.Inject

class SelectCompetitionViewModel @Inject constructor(private val competitionsInteractor: CompetitionsInteractor): BaseViewModel() {

    private val _competitions: MutableLiveData<List<CompetitionsUIModel>> = MutableLiveData()
    val competitions: LiveData<List<CompetitionsUIModel>>
        get() = _competitions

    init {
        launch {
            val res = competitionsInteractor.getList()
            _competitions.value = CompetitionsMapper.toUiModel(res)
        }
    }
}
