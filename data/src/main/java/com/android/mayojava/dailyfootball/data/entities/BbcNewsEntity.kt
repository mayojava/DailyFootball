package com.android.mayojava.dailyfootball.data.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bbc_sports")
data class BbcNewsEntity(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id") val id: Long = 0,
    val author: String,
    override val title: String,
    override val description: String,
    override val url: String,
    override val urlToImage: String,
    override val publishedAt: String,
    override val content: String
): NewsDbEntity
