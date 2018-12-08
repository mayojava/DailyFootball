package com.android.mayojava.dailyfootball.competitions

import com.android.mayojava.dailyfootball.data.entities.CompetitionsEntity

object CompetitionsMapper {
    fun toUiModel(entity: List<CompetitionsEntity>): List<CompetitionsUIModel> {
        return entity.map {
            CompetitionsUIModel(
                it.id,
                it.name,
                it.code,
                it.emblemUrl,
                it.numberOfAvailableSeasons,
                it.currentSeason.startDate,
                it.currentSeason.endDate,
                it.currentSeason.currentMatchday
            )
        }
    }
}
