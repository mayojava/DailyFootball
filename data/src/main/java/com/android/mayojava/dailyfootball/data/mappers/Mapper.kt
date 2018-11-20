package com.android.mayojava.dailyfootball.data.mappers

interface Mapper<F, T> {
    fun map(from: F): T
}
