package com.android.mayojava.dailyfootball.data.services

import com.android.mayojava.dailyfootball.data.responseentities.CompetitionResponse
import com.android.mayojava.dailyfootball.data.responseentities.MatchesResponse
import com.android.mayojava.dailyfootball.data.responseentities.Standings
import com.android.mayojava.dailyfootball.data.responseentities.TeamsForCompetitionResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface FootballDataService {
    /**
     * returns matches for a competition for the current match day
     */
    @GET("competitions/{id}/matches")
    fun matches(
        @Path("id") competitionId: Int,
        @Query("matchday") matchday: String): Call<MatchesResponse>

    /**
     * returns list of competitions
     */
    @GET("competitions")
    fun competitions(): Call<CompetitionResponse>

    /**
     * returns standings for competition
     */
    @GET("competitions/{id}/standings")
    fun standings(
        @Path("id") competitionId: Int
    ): Call<Standings>

    /**
     * returns list of teams in a competition
     */
    @GET("competitions/{id}/teams")
    fun teams(
        @Path("id") competitionId: Int
    ): Call<TeamsForCompetitionResponse>
}
