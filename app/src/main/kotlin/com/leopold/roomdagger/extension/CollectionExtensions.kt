package com.leopold.roomdagger.extension

/**
 * @author Leopold
 */

fun <T> List<T>.asArrayList(): ArrayList<T> {
    val result = arrayListOf<T>()
    forEach { result.add(it) }
    return result
}

fun <T> List<T>.getSatety(position: Int): T? {
    if (position < 0 || position >= size) {
        return null
    }

    return this[position]
}