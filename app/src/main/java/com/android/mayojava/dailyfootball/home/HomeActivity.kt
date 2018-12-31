package com.android.mayojava.dailyfootball.home

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.android.mayojava.dailyfootball.R
import com.android.mayojava.dailyfootball.base.BaseActivity
import kotlinx.android.synthetic.main.main_nav_host.*


class HomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_nav_host)
        setupBottomNavigation()
    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.nav_host_fragment).navigateUp()

    private fun setupBottomNavigation() {
        appBottomNav.setupWithNavController(findNavController(R.id.nav_host_fragment))
    }
}
