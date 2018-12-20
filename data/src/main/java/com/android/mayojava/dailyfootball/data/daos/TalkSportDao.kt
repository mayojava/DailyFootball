package com.android.mayojava.dailyfootball.data.daos

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.android.mayojava.dailyfootball.data.entities.TalkSportEntity
import io.reactivex.Flowable

@Dao
interface TalkSportDao: BaseDao<TalkSportEntity> {
    @Query("DELETE FROM talk_sport")
    fun deleteAllNews()

    @Query("SELECT * FROM talk_sport ORDER BY publishedAt DESC")
    fun getLatestNews(): Flowable<List<TalkSportEntity>>

    @Query("SELECT * FROM talk_sport ORDER BY publishedAt DESC")
    suspend fun getLatestNewsList(): List<TalkSportEntity>

    @Query("SELECT * FROM talk_sport ORDER BY publishedAt DESC")
    fun getNewsPaginated(): DataSource.Factory<Int, TalkSportEntity>

    @Query("SELECT * FROM talk_sport where id = :newsId ")
    suspend fun getNewsById(newsId: Long): TalkSportEntity

    @Transaction
    suspend fun deleteAllItemsAndInsertAll(talkSport: List<TalkSportEntity>) {
        deleteAllNews()
        insert(talkSport)
    }
}
