package com.android.mayojava.dailyfootball.data.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.mayojava.dailyfootball.data.entities.LastRefreshTimeEntity

@Dao
interface LastRefreshTimeDao: BaseDao<LastRefreshTimeEntity> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRefreshTime(source: LastRefreshTimeEntity)

    @Query("SELECT lastRefreshTime FROM last_refresh_time WHERE source = :source")
    suspend fun getSourceRefreshTime(source: String): Long
}
