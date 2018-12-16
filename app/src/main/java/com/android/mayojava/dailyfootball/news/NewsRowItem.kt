package com.android.mayojava.dailyfootball.news

data class NewsRowItem(
    val id: Long,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String,
    val publishedAt: String,
    val content: String
)
