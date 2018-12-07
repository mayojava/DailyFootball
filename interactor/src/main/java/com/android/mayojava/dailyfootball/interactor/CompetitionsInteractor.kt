package com.android.mayojava.dailyfootball.interactor

import com.android.mayojava.dailyfootball.data.entities.CompetitionsEntity
import com.android.mayojava.dailyfootball.data.repositories.competition.CompetitionsRepository
import io.reactivex.Flowable
import javax.inject.Inject

class CompetitionsInteractor @Inject constructor(private val competitionsRepository: CompetitionsRepository): BaseInteractor<None, CompetitionsEntity>() {

    override suspend fun execute(params: None) {
        competitionsRepository.fetchCompetitions()
    }

    override fun createObservable(): Flowable<CompetitionsEntity> {
        return competitionsRepository.observeCompetitions()
    }
}
