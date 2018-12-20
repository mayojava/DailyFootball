package com.android.mayojava.dailyfootball.newsdetails

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsDetailsViewModel::class.java)
        viewModel.selectedNews.observe(viewLifecycleOwner, Observer{ selectedNews ->
            details_toolbar.title = selectedNews.title
            news_content.text = if(selectedNews.content.isNotEmpty()) selectedNews.content else selectedNews.description
            GlideApp.with(this)
                .load(selectedNews.urlToImage)
                .into(newsImage)

            readMore.setOnClickListener {
                val builder = CustomTabsIntent.Builder()
                builder.setStartAnimations(it.context, R.anim.slide_in_right, R.anim.slide_out_left)
                builder.setExitAnimations(it.context, R.anim.slide_in_left, R.anim.slide_out_right)
                val intent = builder.build()
                intent.launchUrl(context, Uri.parse(selectedNews.url))
            }
        })

        val arguments = NewsDetailsFragmentArgs.fromBundle(arguments)
        viewModel.fetchSelectedNews(arguments.stringArgumentNewsId, arguments.stringArgumentNewsSource)
    }
}
