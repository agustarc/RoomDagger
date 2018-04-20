package com.leopold.roomdagger

import android.app.Activity
import com.leopold.roomdagger.annotation.UserScope
import dagger.Module
import dagger.Provides

/**
 * @author Leopold
 */
@Module
class ActivityModule(private val activity: Activity) {

    @Provides
    @UserScope
    fun provideActivity() = activity
}