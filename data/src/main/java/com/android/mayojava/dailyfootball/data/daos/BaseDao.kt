package com.android.mayojava.dailyfootball.data.daos

import androidx.room.*

@Dao
interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(items: List<T>)

    @Delete
    fun delete(item: T)
}
