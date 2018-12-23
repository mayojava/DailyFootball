package com.android.mayojava.dailyfootball.competitions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.mayojava.dailyfootball.Constants
import com.android.mayojava.dailyfootball.R
import com.android.mayojava.dailyfootball.base.BaseFragment
import com.android.mayojava.dailyfootball.injection.AppViewModelFactory
import kotlinx.android.synthetic.main.competitions.*
import javax.inject.Inject

class SelectCompetitionFragment: BaseFragment() {
    @Inject lateinit var viewModelFactory: AppViewModelFactory
    private val adapter: MutableList<CompetitionsUIModel> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.competitions, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        compsToolbar.setupWithNavController(findNavController())
        val vm = ViewModelProviders.of(this, viewModelFactory).get(SelectCompetitionViewModel::class.java)
        vm.competitions.observe(this, Observer {
            adapter.clear()
            adapter.addAll(it)
        })
        list()
    }

    private fun list() {
        image_premier_league.setOnClickListener {
            findNavController().navigate(SelectCompetitionFragmentDirections.toCompetitions())

        }

        image_champions_league.setOnClickListener {
            val comp = adapter.first { model -> model.id == Constants.CHAMPIONS_LEAGUE_ID }
            Toast.makeText(context, comp.name, Toast.LENGTH_LONG).show()
        }
    }
}
