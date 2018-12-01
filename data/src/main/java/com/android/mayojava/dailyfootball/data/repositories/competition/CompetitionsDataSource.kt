package com.android.mayojava.dailyfootball.data.repositories.competition

import arrow.core.Try
import com.android.mayojava.dailyfootball.data.entities.CompetitionsEntity

interface CompetitionsDataSource {
    suspend fun getCompetitions(): Try<List<CompetitionsEntity>>
}
