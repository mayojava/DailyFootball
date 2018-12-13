package com.android.mayojava.dailyfootball.news

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.android.mayojava.dailyfootball.R
import com.android.mayojava.dailyfootball.news.bbc.BbcNewsFragment
import com.android.mayojava.dailyfootball.news.footballitalia.FootBallItalia
import com.android.mayojava.dailyfootball.news.fourfourtwo.FourFourTwo
import com.android.mayojava.dailyfootball.news.talksport.TalkSport
import com.android.mayojava.dailyfootball.news.thesportbible.TheSportBible
import kotlinx.android.synthetic.main.fragment_news_host.*

class NewsHostFragment: Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_news_host, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as AppCompatActivity).setSupportActionBar(bbc_toolbar)
        val navController = findNavController()
        val appBarConfig = AppBarConfiguration(navController.graph)
        (activity as AppCompatActivity).setupActionBarWithNavController(navController, appBarConfig)

        val tabAdapter = NewsViewPagerAdapter(childFragmentManager)
        //add tabs
        tabAdapter.addFragments(BbcNewsFragment())
        tabAdapter.addFragments(FourFourTwo())
        tabAdapter.addFragments(TalkSport())
        tabAdapter.addFragments(TheSportBible())
        tabAdapter.addFragments(FootBallItalia())

        news_pager.adapter = tabAdapter
        news_sliding_tab.setupWithViewPager(news_pager)
    }
}
