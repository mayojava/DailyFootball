package com.android.mayojava.dailyfootball.news.fourfourtwo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.mayojava.dailyfootball.base.BaseViewModel
import com.android.mayojava.dailyfootball.base.util.AppCoroutineDispatchers
import com.android.mayojava.dailyfootball.interactor.FourFourTwoInteractor
import com.android.mayojava.dailyfootball.news.NewsMapper
import com.android.mayojava.dailyfootball.news.NewsRowItem
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import javax.inject.Inject

class FourFourTwoViewModel @Inject constructor(private val fourFourTwoInteractor: FourFourTwoInteractor,
                                               dispatchers: AppCoroutineDispatchers): BaseViewModel() {
    private val _fourFourTwoNews: MutableLiveData<List<NewsRowItem>> = MutableLiveData()
    val fourFourTwoNews: LiveData<List<NewsRowItem>>
        get() = _fourFourTwoNews

    init {
        launch(dispatchers.io) {
            fourFourTwoInteractor.observe().consumeEach {
                _fourFourTwoNews.postValue(NewsMapper.toRowItem(it))
            }
        }

        launch(dispatchers.io) {
            fourFourTwoInteractor()
        }
    }
}
