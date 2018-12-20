package com.android.mayojava.dailyfootball.news.bbc

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.mayojava.dailyfootball.base.BaseViewModel
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.interactor.BbcNewsInteractor
import com.android.mayojava.dailyfootball.news.NewsMapper
import com.android.mayojava.dailyfootball.news.NewsRowItem
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class BbcNewsViewModel @Inject constructor(private val bbcNewsInteractor: BbcNewsInteractor,
                                           dispatchers: AppCoroutineDispatchers): BaseViewModel() {

    private val _news: MutableLiveData<List<NewsRowItem>> = MutableLiveData()
    val bbcNews: LiveData<List<NewsRowItem>>
        get() = _news

    init {
        launch(dispatchers.io) {
            bbcNewsInteractor.observe().consumeEach {
                _news.postValue(NewsMapper.toRowItem(it))
            }
        }

        launch(dispatchers.io) {
            bbcNewsInteractor()
        }
    }
}
