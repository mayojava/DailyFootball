package com.android.mayojava.dailyfootball.data.mappers

import com.android.mayojava.dailyfootball.data.entities.NewsDbEntity

object DiffUtil {
    fun<T: NewsDbEntity> diff (oldItems: List<T>, newItems: List<T>): List<T> {
        val titles = oldItems.map { it.title }
        return newItems.filter { !titles.contains(it.title) }
    }
}
