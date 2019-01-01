package com.android.mayojava.dailyfootball.home

import android.os.Bundle
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.mayojava.dailyfootball.R
import com.android.mayojava.dailyfootball.base.BaseActivity
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
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
        removePaddingFromSelectedItem()
    }

    private fun removePaddingFromSelectedItem() {
        val menuView = appBottomNav.getChildAt(0) as BottomNavigationMenuView
        for (i in 0..menuView.childCount) {
            val navItemView = menuView.getChildAt(i)
            if (navItemView is BottomNavigationItemView) {
                val label = navItemView.findViewById<TextView>(R.id.largeLabel)
                label.setPadding(0,0,0,0)
            }
        }
    }
}
