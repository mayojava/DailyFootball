package com.android.mayojava.dailyfootball.data.repositories.fourfourtwo

import arrow.core.Try
import com.android.mayojava.dailyfootball.data.entities.FourFourTwoEntity

interface FourFourTwoDataSource {
    suspend fun fourFourTwoNews(): Try<List<FourFourTwoEntity>>
}
