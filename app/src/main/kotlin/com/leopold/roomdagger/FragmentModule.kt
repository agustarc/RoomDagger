package com.leopold.roomdagger

import android.support.v4.app.Fragment
import com.leopold.roomdagger.annotation.UserScope
import dagger.Module
import dagger.Provides

/**
 * @author Leopold
 */
@Module
class FragmentModule(private val fragment: Fragment) {

    @Provides
    @UserScope
    fun provideFragment() = fragment
}