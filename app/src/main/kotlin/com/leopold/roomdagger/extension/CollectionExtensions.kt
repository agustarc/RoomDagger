package com.leopold.roomdagger.extension

/**
 * @author Leopold
 */

fun <T> List<T>.asArrayList(): ArrayList<T> {
    val result = arrayListOf<T>()
    forEach { result.add(it) }
    return result
}
