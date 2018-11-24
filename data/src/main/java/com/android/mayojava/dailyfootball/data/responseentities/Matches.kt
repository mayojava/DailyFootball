package com.android.mayojava.dailyfootball.data.responseentities

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class MatchesResponse(
    val count: Int,
    val filters: MatchFilter,
    val competition: Competition,
    val matches: List<Match>
)

@JsonClass(generateAdapter = true)
data class Match(
    val id: Int,
    val season: Season,
    val utcDate: String,
    val status: String,
    val matchday: Int,
    val stage: String,
    val group: String = "",
    val lastUpdated: String,
    val score: Score,
    val homeTeam: GameTeamName,
    val awayTeam: GameTeamName,
    val referees: List<Referees>
)

@JsonClass(generateAdapter = true)
data class Score(
    val winner: String,
    val duration: String,
    val fullTime: GameScore,
    val halfTime: GameScore,
    val extraTime: GameScore,
    val penalties: GameScore
)

@JsonClass(generateAdapter = true)
data class GameScore(
    val homeTeam: Int = 0,
    val awayTeam: Int = 0
)

@JsonClass(generateAdapter = true)
data class GameTeamName(
    val id: Int,
    val name: String
)

@JsonClass(generateAdapter = true)
data class Referees (
    val id: Int,
    val name: String,
    val nationality: String? = ""
)

@JsonClass(generateAdapter = true)
data class MatchFilter(val matchday: String)