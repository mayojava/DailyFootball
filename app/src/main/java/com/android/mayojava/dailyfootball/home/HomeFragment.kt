package com.android.mayojava.dailyfootball.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.android.mayojava.dailyfootball.base.BaseFragment
import com.android.mayojava.dailyfootball.R
import com.android.mayojava.dailyfootball.injection.AppViewModelFactory
import kotlinx.android.synthetic.main.new_home.*
import javax.inject.Inject

class HomeFragment: BaseFragment() {
    @Inject lateinit var viewModelFactory: AppViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.new_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        card_competitions.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.navigateToCompetitionSelect())
        }
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        val vm = ViewModelProviders.of(this, viewModelFactory).get(HomeFragmentViewModel::class.java)
        vm.competitions.observe(this, Observer {})
    }
}
