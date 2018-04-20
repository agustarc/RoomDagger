package com.leopold.roomdagger.extension

import android.content.Context
import android.support.annotation.DimenRes

/**
 * @author Leopold
 */

fun Context.getDimenSize(@DimenRes resId: Int): Int {
    return resources.getDimensionPixelSize(resId)
}