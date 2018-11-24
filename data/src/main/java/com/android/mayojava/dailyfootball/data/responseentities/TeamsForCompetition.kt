package com.android.mayojava.dailyfootball.data.responseentities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TeamsForCompetitionResponse(
    val count: Int,
    val competition: CompetitionFetched,
    val season: Season,
    val teams: List<Team>
)

@JsonClass(generateAdapter = true)
data class Team(
    val id: Int,
    val area: Area,
    val name: String,
    val shortName: String,
    val tla: String,
    val crestUrl: String,
    val address: String,
    val phone: String,
    val website: String,
    val email: String,
    val founded: Int,
    val clubColors: Int,
    val venue: String,
    val lastUpdated: String
)

@JsonClass(generateAdapter = true)
data class Season(
    val id: Int,
    val startDate: String,
    val endDate: String,
    val currentMatchday: String
)

@JsonClass(generateAdapter = true)
data class CompetitionFetched(
    val id: Int,
    val area: Area,
    val name: String,
    val code: String,
    val plan: String,
    val lastUpdated: String
)
