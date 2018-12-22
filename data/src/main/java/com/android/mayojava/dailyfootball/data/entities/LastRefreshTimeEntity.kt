package com.android.mayojava.dailyfootball.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "last_refresh_time")
data class LastRefreshTimeEntity(
    @PrimaryKey val source: String,
    val lastRefreshTime: Long
)
