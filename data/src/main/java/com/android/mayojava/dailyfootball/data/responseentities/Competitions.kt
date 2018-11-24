package com.android.mayojava.dailyfootball.data.responseentities

data class CompetitionResponse(
    val count: Int,
    val filters: Filter,
    val competitions: List<Competition>
)

data class Filter(val plan: String)

data class Competition(
    val id: Int,
    val area: Area,
    val name: String,
    val code: String,
    val emblemUrl: String = "",
    val plan: String,
    val currentSeason: CurrentSeason = CurrentSeason(0, "", "", 0),
    val numberOfAvailableSeasons: Int = 0,
    val lastUpdated: String
)

data class CurrentSeason(
    val id: Int,
    val startDate: String,
    val endDate: String,
    val currentMatchday: Int,
    val winner: Winner? = null
)

data class Winner(
    val id: Int,
    val name: String,
    val shortName: String,
    val tla: String,
    val crestUrl: String
)

data class Area(val id: Int, val name: String)