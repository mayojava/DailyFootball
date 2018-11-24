package com.android.mayojava.dailyfootball.data.responseentities

data class Standings(
    val competition: Competition,
    val season: CurrentSeason,
    val standings: List<Standing>
)

data class Standing(
    val stage: String,
    val type: String,
    val group: String? = null,
    val table: List<Table>
)

data class Table(
    val position: Int,
    val team: TableTeam,
    val playedGames: Int,
    val won: Int,
    val draw: Int,
    val lost: Int,
    val points: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int
)

data class TableTeam(
    val id: Int,
    val name: String,
    val crestUrl: String
)