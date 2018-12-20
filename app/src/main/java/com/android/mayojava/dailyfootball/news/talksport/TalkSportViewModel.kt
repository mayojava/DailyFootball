package com.android.mayojava.dailyfootball.news.talksport

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.mayojava.dailyfootball.base.BaseViewModel
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.interactor.TalkSportInteractor
import com.android.mayojava.dailyfootball.news.NewsMapper
import com.android.mayojava.dailyfootball.news.NewsRowItem
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class TalkSportViewModel @Inject constructor(private val talkSportInteractor: TalkSportInteractor,
                                             dispatchers: AppCoroutineDispatchers): BaseViewModel() {

    private val _talkSportNews: MutableLiveData<List<NewsRowItem>> = MutableLiveData()
    val talkSportNews: LiveData<List<NewsRowItem>>
        get() = _talkSportNews

    init {
        launch(dispatchers.io) {
            talkSportInteractor.observe().consumeEach {
                _talkSportNews.postValue(NewsMapper.toRowItem(it))
            }
        }

        launch(dispatchers.io) {
            talkSportInteractor()
        }
    }
}
