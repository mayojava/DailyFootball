package com.android.mayojava.dailyfootball.news.bbc

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.android.mayojava.dailyfootball.R
import com.android.mayojava.dailyfootball.base.BaseFragment
import com.android.mayojava.dailyfootball.news.RecyclerAdapter
import kotlinx.android.synthetic.main.bbc_news_fragment.*

class BbcNewsFragment: BaseFragment() {
    private val adapter = RecyclerAdapter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.bbc_news_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        bbc_news_recycler.layoutManager = layoutManager
        bbc_news_recycler.adapter = adapter
    }
}
