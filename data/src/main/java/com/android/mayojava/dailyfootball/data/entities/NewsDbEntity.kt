package com.android.mayojava.dailyfootball.data.entities

interface NewsDbEntity {
    val id: Long
    val title: String
    val description: String
    val url: String
    val urlToImage: String
    val publishedAt: String
    val content: String
}
