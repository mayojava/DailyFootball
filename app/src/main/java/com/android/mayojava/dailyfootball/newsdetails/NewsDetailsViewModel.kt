package com.android.mayojava.dailyfootball.newsdetails

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.mayojava.dailyfootball.base.BaseViewModel
import com.android.mayojava.dailyfootball.news.NewsRowItem
import javax.inject.Inject

class NewsDetailsViewModel @Inject constructor(): BaseViewModel() {
    private val _selectedNews = MutableLiveData<NewsRowItem>()
    val selectedNews: LiveData<NewsRowItem>
        get() = _selectedNews

    fun fetchSelectedNews() {

    }
}
