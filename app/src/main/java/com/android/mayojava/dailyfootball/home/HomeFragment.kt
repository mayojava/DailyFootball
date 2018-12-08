package com.android.mayojava.dailyfootball.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.android.mayojava.dailyfootball.base.BaseFragment
import com.android.mayojava.dailyfootball.R
import kotlinx.android.synthetic.main.new_home.*

class HomeFragment: BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.new_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_competitions.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.navigateToCompetitionSelect())
        }
    }
}
