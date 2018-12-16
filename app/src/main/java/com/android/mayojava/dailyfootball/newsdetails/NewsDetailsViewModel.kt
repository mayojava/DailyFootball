package com.android.mayojava.dailyfootball.newsdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.mayojava.dailyfootball.Constants
import com.android.mayojava.dailyfootball.base.BaseViewModel
import com.android.mayojava.dailyfootball.interactor.BbcNewsInteractor
import com.android.mayojava.dailyfootball.news.NewsMapper
import com.android.mayojava.dailyfootball.news.NewsRowItem
import kotlinx.coroutines.launch
import javax.inject.Inject

class NewsDetailsViewModel @Inject constructor(
    private val bbcNewsInteractor: BbcNewsInteractor): BaseViewModel() {

    private val _selectedNews = MutableLiveData<NewsRowItem>()
    val selectedNews: LiveData<NewsRowItem>
        get() = _selectedNews

    fun fetchSelectedNews(newsId: Int, newsSource: String) {
        when(newsSource) {
            Constants.BBC ->  {
                launch {
                    _selectedNews.postValue(NewsMapper.toSingleNewsItem(bbcNewsInteractor.getNewsById(newsId.toLong())))
                }
            }
        }
    }
}
