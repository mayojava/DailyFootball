package com.android.mayojava.dailyfootball.base

import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import dagger.android.support.DaggerFragment

abstract class BaseFragment: DaggerFragment() {
    fun setupToolbar(toolbar: Toolbar) {
        (activity as AppCompatActivity).setSupportActionBar(toolbar)
    }

    fun setupNavController(navController: NavController) {
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        (activity as AppCompatActivity).setupActionBarWithNavController(navController, appBarConfiguration)
    }
}
