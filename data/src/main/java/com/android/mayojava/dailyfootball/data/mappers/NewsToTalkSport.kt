package com.android.mayojava.dailyfootball.data.mappers

import com.android.mayojava.dailyfootball.data.entities.TalkSportEntity
import com.android.mayojava.dailyfootball.data.responseentities.News

object NewsToTalkSport: Mapper<News, List<TalkSportEntity>> {
    override fun map(from: News): List<TalkSportEntity> {
        return from.articles.map { TalkSportEntity(
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
