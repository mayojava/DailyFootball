package com.android.mayojava.dailyfootball.data.mappers

import com.android.mayojava.dailyfootball.data.entities.BbcNewsEntity
import com.android.mayojava.dailyfootball.data.responseentities.News

object NewsToBbcSport: Mapper<News, List<BbcNewsEntity>> {
    override fun map(from: News): List<BbcNewsEntity> {
        return from.articles.map { it -> BbcNewsEntity(
            author = it.author,
            title = it.title,
            description = it.description ?: "",
            url = it.url,
            urlToImage = it.urlToImage ?: "",
            publishedAt = it.publishedAt,
            content = it.content ?: ""
        ) }
    }
}
