package com.android.mayojava.dailyfootball.data.repositories.talksport

import arrow.core.Try
import com.android.mayojava.dailyfootball.data.entities.TalkSportEntity

interface TalkSportDataSource {
    suspend fun talkSportNews(): Try<List<TalkSportEntity>>
}
