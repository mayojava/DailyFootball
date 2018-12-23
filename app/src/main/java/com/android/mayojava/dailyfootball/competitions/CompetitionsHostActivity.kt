package com.android.mayojava.dailyfootball.competitions

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.mayojava.dailyfootball.R
import kotlinx.android.synthetic.main.competitions_host_activity.*

class CompetitionsHostActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.competitions_host_activity)
        setupBottomNavigation()
    }

    private fun setupBottomNavigation() {
        val navController = findNavController(R.id.competitionsNavHost)
        competitionsBottomNav.setupWithNavController(navController)
    }
}
