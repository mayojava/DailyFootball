package com.android.mayojava.dailyfootball.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "four_four_two")
data class FourFourTwoEntity(
    @PrimaryKey(autoGenerate = true) override val id: Long = 0,
    val author: String,
    override val title: String,
    override val description: String,
    override val url: String,
    override val urlToImage: String,
    override val publishedAt: String,
    override val content: String
): NewsDbEntity
