package com.android.mayojava.dailyfootball.news.talksport

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mayojava.dailyfootball.Constants
import com.android.mayojava.dailyfootball.R
import com.android.mayojava.dailyfootball.base.BaseFragment
import com.android.mayojava.dailyfootball.injection.AppViewModelFactory
import com.android.mayojava.dailyfootball.news.NewsHostFragmentDirections
import com.android.mayojava.dailyfootball.news.RecyclerAdapter
import kotlinx.android.synthetic.main.dummy_fragment.*
import kotlinx.android.synthetic.main.news_list_recycler_view.*
import javax.inject.Inject

class TalkSportFragment: BaseFragment() {
    @Inject lateinit var viewModelFactory: AppViewModelFactory

    private val adapter = RecyclerAdapter(rowLayoutId = R.layout.news_row_item) {
        val direction = NewsHostFragmentDirections.toNewsDetails(it.id.toInt(), Constants.TALKSPORT)
        findNavController().navigate(direction)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.news_list_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(context)
        news_recycler.layoutManager = layoutManager
        news_recycler.adapter = adapter
        setupRecyclerItemDecorator(news_recycler, view.context)

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(TalkSportViewModel::class.java)
        viewModel.talkSportNews.observe(viewLifecycleOwner, Observer { adapter.setItems(it) })
    }
}
