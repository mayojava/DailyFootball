package com.android.mayojava.dailyfootball.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.android.support.DaggerFragment

abstract class BaseFragment: DaggerFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val toolbar = view.findViewById<Toolbar>(R.id.toolbar)
//        (activity as AppCompatActivity).setSupportActionBar(toolbar)
//        (activity as AppCompatActivity).setupActionBarWithNavController(findNavController())
    }
}
