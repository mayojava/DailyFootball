package com.android.mayojava.dailyfootball.widget

import android.content.Context
import android.view.LayoutInflater
import android.widget.PopupWindow
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.mayojava.dailyfootball.R
import com.android.mayojava.dailyfootball.competitions.CompetitionSelectAdapter

class CompetitionsDropDownMenu(private val context: Context): PopupWindow(context) {
    init {
        setupView()
    }

    private fun setupView() {
        val view = LayoutInflater.from(context).inflate(R.layout.competitions_drop_down_recycler, null) as RecyclerView
        view.setHasFixedSize(true)
        view.layoutManager = LinearLayoutManager(context)
        view.addItemDecoration(DividerItemDecoration(context, LinearLayoutManager.VERTICAL))
    }
}