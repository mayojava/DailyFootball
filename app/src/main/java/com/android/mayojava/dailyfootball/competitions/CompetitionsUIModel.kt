package com.android.mayojava.dailyfootball.competitions

data class CompetitionsUIModel(
    val id: Int,
    val name: String,
    val code: String,
    val emblemUrl: String? = "",
    val numberOfSeasons: Int,
    val seasonStart: String,
    val seasonEnd: String,
    val matchDay: Int
)
