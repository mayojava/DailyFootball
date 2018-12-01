package com.android.mayojava.dailyfootball.data.mappers

import com.android.mayojava.dailyfootball.data.entities.AreaEntity
import com.android.mayojava.dailyfootball.data.entities.CompetitionsEntity
import com.android.mayojava.dailyfootball.data.entities.CurrentSeasonEntity
import com.android.mayojava.dailyfootball.data.entities.WinnerEntity
import com.android.mayojava.dailyfootball.data.responseentities.Area
import com.android.mayojava.dailyfootball.data.responseentities.CompetitionResponse
import com.android.mayojava.dailyfootball.data.responseentities.CurrentSeason
import com.android.mayojava.dailyfootball.data.responseentities.Winner

object CompetitionsToDbEntity: Mapper<CompetitionResponse, List<CompetitionsEntity>> {

    override fun map(from: CompetitionResponse): List<CompetitionsEntity> {
        return from.competitions.map {
            CompetitionsEntity(it.id,
                toAreaEntity(it.area),
                it.name, it.code, it.emblemUrl, it.plan,
                toCurrentSeasonEntity(it.currentSeason),
                it.numberOfAvailableSeasons, it.lastUpdated)
        }
    }

    private fun toAreaEntity(area: Area) = AreaEntity(area.id, area.name)

    private fun toCurrentSeasonEntity(season: CurrentSeason) = CurrentSeasonEntity(
        season.id, season.startDate, season.endDate, season.currentMatchday, toWinnerEntity(season.winner)
    )

    private fun toWinnerEntity(winner: Winner?): WinnerEntity? = winner?.let {
        WinnerEntity(it.id, it.name, it.shortName, it.tla, it.crestUrl)
    }
}
