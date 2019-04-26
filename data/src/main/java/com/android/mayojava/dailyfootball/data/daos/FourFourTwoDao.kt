package com.android.mayojava.dailyfootball.data.daos

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.android.mayojava.dailyfootball.data.entities.FourFourTwoEntity
import io.reactivex.Flowable

@Dao
interface FourFourTwoDao: BaseDao<FourFourTwoEntity> {
    @Query("DELETE FROM four_four_two")
    fun deleteAllNews()

    @Query("SELECT * FROM four_four_two ORDER BY publishedAt DESC")
    fun getLatestNews(): Flowable<List<FourFourTwoEntity>>

    @Query("SELECT * FROM four_four_two ORDER BY publishedAt DESC")
    suspend fun getLatestNewsList(): List<FourFourTwoEntity>

    @Query("SELECT * FROM four_four_two ORDER BY publishedAt DESC")
    fun getNewsPaginated()

    @Query("SELECT * FROM four_four_two WHERE id = :newsId")
    suspend fun getNewsById(newsId: Long): FourFourTwoEntity

    @Transaction
    suspend fun deleteAllAndInsert(fourFourTwo: List<FourFourTwoEntity>) {
        deleteAllNews()
        insert(fourFourTwo)
    }
}
