package com.android.mayojava.dailyfootball.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.mayojava.dailyfootball.base.BaseFragment
import com.android.mayojava.dailyfootball.R
import com.android.mayojava.dailyfootball.injection.AppViewModelFactory
import kotlinx.android.synthetic.main.home_fragment.*
import javax.inject.Inject

class HomeFragment: BaseFragment() {
    @Inject lateinit var viewModelFactory: AppViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        toolbar.setupWithNavController(findNavController())
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ViewModelProviders.of(this, viewModelFactory).get(HomeFragmentViewModel::class.java)
    }
}
