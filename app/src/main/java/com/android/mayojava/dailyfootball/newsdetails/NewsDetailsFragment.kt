package com.android.mayojava.dailyfootball.newsdetails

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.android.mayojava.dailyfootball.GlideApp
import com.android.mayojava.dailyfootball.R
import com.android.mayojava.dailyfootball.base.BaseFragment
import com.android.mayojava.dailyfootball.injection.AppViewModelFactory
import kotlinx.android.synthetic.main.news_details_fragment.*
import javax.inject.Inject

class NewsDetailsFragment: BaseFragment() {
    @Inject lateinit var viewModelFactory: AppViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.news_details_fragment, container, false)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsDetailsViewModel::class.java)
        viewModel.selectedNews.observe(this, Observer{
            details_toolbar.title = it.title
            news_content.text = if(it.content.isNotEmpty()) it.content else it.description
            GlideApp.with(this)
                .load(it.urlToImage)
                .into(newsImage)
        })

        val arguments = NewsDetailsFragmentArgs.fromBundle(arguments)
        viewModel.fetchSelectedNews(arguments.stringArgumentNewsId, arguments.stringArgumentNewsSource)
    }
}
