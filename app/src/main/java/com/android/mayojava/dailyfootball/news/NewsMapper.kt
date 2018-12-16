package com.android.mayojava.dailyfootball.news

import com.android.mayojava.dailyfootball.data.entities.NewsDbEntity

object NewsMapper {
    fun toRowItem(entities: List<NewsDbEntity>): List<NewsRowItem> {
        return entities.map {
            NewsRowItem(
                it.id,
                it.title,
                it.description,
                it.url,
                it.urlToImage,
                it.publishedAt,
                it.content
            )
        }
    }

    fun toSingleNewsItem(selectedNews: NewsDbEntity): NewsRowItem {
        return NewsRowItem(
            selectedNews.id,
            selectedNews.title,
            selectedNews.description,
            selectedNews.url,
            selectedNews.urlToImage,
            selectedNews.publishedAt,
            selectedNews.content
        )
    }
}
