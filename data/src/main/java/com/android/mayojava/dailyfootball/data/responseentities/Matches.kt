package com.android.mayojava.dailyfootball.data.responseentities

data class MatchesResponse(
    val count: Int,
    val filters: MatchFilter,
    val competition: Competition,
    val matches: List<Match>
)

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

data class Score(
    val winner: String,
    val duration: String,
    val fullTime: GameScore,
    val halfTime: GameScore,
    val extraTime: GameScore,
    val penalties: GameScore
)

data class GameScore(
    val homeTeam: Int = 0,
    val awayTeam: Int = 0
)

data class GameTeamName(
    val id: Int,
    val name: String
)

data class Referees (
    val id: Int,
    val name: String,
    val nationality: String? = ""
)
data class MatchFilter(val matchday: String)