package com.android.mayojava.dailyfootball.data.mappers

import com.android.mayojava.dailyfootball.data.entities.FourFourTwoEntity
import com.android.mayojava.dailyfootball.data.responseentities.News

object NewsToFourFourTwo: Mapper<News, List<FourFourTwoEntity>> {
    override fun map(from: News): List<FourFourTwoEntity> {
        return from.articles.map {
            FourFourTwoEntity(
                author = it.author,
                title = it.title,
                description = it.description ?: "",
                url = it.url,
                urlToImage = it.urlToImage ?: "",
                publishedAt = it.publishedAt,
                content = it.content ?: ""
            )
        }
    }
}
