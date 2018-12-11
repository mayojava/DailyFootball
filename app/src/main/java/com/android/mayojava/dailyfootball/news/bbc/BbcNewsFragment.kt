package com.android.mayojava.dailyfootball.news.bbc

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mayojava.dailyfootball.R
import com.android.mayojava.dailyfootball.base.BaseFragment
import com.android.mayojava.dailyfootball.injection.AppViewModelFactory
import com.android.mayojava.dailyfootball.news.RecyclerAdapter
import kotlinx.android.synthetic.main.bbc_news_fragment.*
import javax.inject.Inject

class BbcNewsFragment: BaseFragment() {
    @Inject lateinit var viewModelFactory: AppViewModelFactory

    private val adapter = RecyclerAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bbc_news_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bbc_news_recycler.layoutManager = LinearLayoutManager(context)
        bbc_news_recycler.adapter = adapter
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val vm = ViewModelProviders.of(this, viewModelFactory).get(BbcNewsViewModel::class.java)
        vm.bbcNews.observe(this, Observer {
            adapter.setItems(it)
        })
    }
}
