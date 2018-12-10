package com.android.mayojava.dailyfootball.news

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class NewsViewPagerAdapter(fragmentManager: FragmentManager): FragmentStatePagerAdapter(fragmentManager) {
    private val fragments = mutableListOf<Fragment>()
    private val titles = arrayOf("BBC", "Four-Four-Two", "TalkSport", "TheSportBible", "FootballItalia")

    override fun getItem(position: Int): Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? = titles[position]

    fun addFragments(fragment: Fragment) {
        fragments.add(fragment)
    }
}
