package com.android.mayojava.dailyfootball.data.repositories.competition

import com.android.mayojava.dailyfootball.data.daos.CompetitionsDao
import com.android.mayojava.dailyfootball.data.entities.CompetitionsEntity
import io.reactivex.Flowable
import javax.inject.Inject

class ComptetionsLocalDataSource @Inject constructor(private val competitionsDao: CompetitionsDao) {

    fun observeCompetitions(): Flowable<CompetitionsEntity> = competitionsDao.getCompetitions()

    fun insert(competitions: List<CompetitionsEntity>) = competitionsDao.deleteAllAndInsert(competitions)
}
