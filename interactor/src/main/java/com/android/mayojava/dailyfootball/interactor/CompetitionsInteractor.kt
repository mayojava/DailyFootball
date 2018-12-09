package com.android.mayojava.dailyfootball.interactor

import com.android.mayojava.dailyfootball.data.entities.CompetitionsEntity
import com.android.mayojava.dailyfootball.data.repositories.competition.CompetitionsRepository
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.reactive.openSubscription
import javax.inject.Inject

class CompetitionsInteractor @Inject constructor(private val competitionsRepository: CompetitionsRepository): RunnableInteractor<List<CompetitionsEntity>>() {

    override suspend fun execute() {
        competitionsRepository.fetchCompetitions()
    }

    override fun observe(): ReceiveChannel<List<CompetitionsEntity>> {
        return competitionsRepository.observeCompetitions().openSubscription()
    }
}
