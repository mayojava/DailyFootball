package com.android.mayojava.dailyfootball.data.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "competitions")
data class CompetitionsEntity(
    @PrimaryKey val id: Int,
    @Embedded val area: AreaEntity,
    val name: String,
    val code: String,
    val emblemUrl: String?,
    val plan: String,
    @Embedded val currentSeason: CurrentSeasonEntity,
    val numberOfAvailableSeasons: Int,
    val lastUpdated: String
)

data class AreaEntity(
    @ColumnInfo(name = "area_id") val id: Int,
    @ColumnInfo(name = "area_name") val name: String
)

data class CurrentSeasonEntity(
    @ColumnInfo(name = "season_id") val id: Int,
    val startDate: String,
    val endDate: String,
    val currentMatchday: Int,
    @Embedded val winner: WinnerEntity? = null
)

data class WinnerEntity(
    @ColumnInfo(name = "winner_id") val id: Int,
    @ColumnInfo(name = "winner_name") val name: String,
    @ColumnInfo(name = "winner_short_name") val shortName: String,
    val tla: String,
    val crestUrl: String?
)
