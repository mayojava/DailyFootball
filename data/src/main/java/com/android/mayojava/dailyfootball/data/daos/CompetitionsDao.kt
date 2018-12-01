package com.android.mayojava.dailyfootball.data.daos

import androidx.room.Query
import androidx.room.Transaction
import com.android.mayojava.dailyfootball.data.entities.CompetitionsEntity
import io.reactivex.Flowable

interface CompetitionsDao: BaseDao<CompetitionsEntity> {
    @Query("DELETE FROM competitions")
    fun deleteAllItems()

    @Query("SELECT * FROM competitions")
    fun getCompetitions(): Flowable<CompetitionsEntity>

    @Transaction
    fun deleteAllAndInsert(items: List<CompetitionsEntity>) {
        deleteAllItems()
        insert(items)
    }
}
