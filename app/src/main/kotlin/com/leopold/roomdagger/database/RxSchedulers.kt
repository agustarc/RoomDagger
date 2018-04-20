package com.leopold.roomdagger.database

import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @author Leopold
 */

fun <T> schedulerIO(flowable: Flowable<T>): Flowable<T> {
    return flowable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
}