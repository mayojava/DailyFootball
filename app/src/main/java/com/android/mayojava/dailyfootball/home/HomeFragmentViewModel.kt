package com.android.mayojava.dailyfootball.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.mayojava.dailyfootball.base.BaseViewModel
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.base.util.Logger
import com.android.mayojava.dailyfootball.competitions.CompetitionsMapper
import com.android.mayojava.dailyfootball.competitions.CompetitionsUIModel
import com.android.mayojava.dailyfootball.interactor.CompetitionsInteractor
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class HomeFragmentViewModel @Inject constructor(private val competitionsInteractor: CompetitionsInteractor,
                                                private val dispatchers: AppCoroutineDispatchers): BaseViewModel() {

    private val _competitions: MutableLiveData<List<CompetitionsUIModel>> = MutableLiveData()
    val competitions: LiveData<List<CompetitionsUIModel>>
        get() = _competitions

    init {
        launch {
            competitionsInteractor()

            withContext(dispatchers.computation) {
                competitionsInteractor.observe().consumeEach {
                    _competitions.postValue(CompetitionsMapper.toUiModel(it))
                }
            }
        }

    }
}
