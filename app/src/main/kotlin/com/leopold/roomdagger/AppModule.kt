package com.leopold.roomdagger

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Leopold
 */
@Module
class AppModule(private val app: App) {

    @Provides
    @Singleton
    fun provideApp() = app
}