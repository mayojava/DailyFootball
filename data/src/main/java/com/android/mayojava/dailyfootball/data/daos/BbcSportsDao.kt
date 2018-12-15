package com.android.mayojava.dailyfootball.data.daos

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity
import io.reactivex.Flowable

@Dao
interface BbcSportsDao: BaseDao<BbcNewsEntity> {
    @Query("DELETE FROM bbc_sports")
    suspend fun deleteAllItems()

    @Query("SELECT * FROM bbc_sports ORDER BY publishedAt DESC")
    fun getAllNews(): Flowable<List<BbcNewsEntity>>

    @Query("SELECT * FROM bbc_sports ORDER BY publishedAt DESC")
    fun getNewsList(): List<BbcNewsEntity>

    @Query("SELECT * FROM bbc_sports ORDER BY publishedAt DESC")
    fun getNewsPaginated(): DataSource.Factory<Int, BbcNewsEntity>

    @Transaction
    suspend fun deleteAllItemsAndInsertAll(bbcNews: List<BbcNewsEntity>) {
        deleteAllItems()
        insert(bbcNews)
    }
}
