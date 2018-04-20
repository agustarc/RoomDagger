package com.leopold.roomdagger

import android.app.Application
import android.content.Context
import com.leopold.roomdagger.component.DaggerSingletonComponent
import com.leopold.roomdagger.component.SingletonComponent

/**
 * @author Leopold
 */
class App : Application() {

    val singleton: SingletonComponent by lazy {
        DaggerSingletonComponent.builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {
        fun getSingletonComponent(context: Context): SingletonComponent {
            return (context.applicationContext as App).singleton
        }
    }
}