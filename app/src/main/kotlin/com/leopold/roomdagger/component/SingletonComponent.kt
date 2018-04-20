package com.leopold.roomdagger.component

import com.leopold.roomdagger.AppModule
import com.leopold.roomdagger.database.RoomModule
import com.leopold.roomdagger.database.dao.MemoDao
import dagger.Component
import javax.inject.Singleton

/**
 * @author Leopold
 */
@Singleton
@Component(modules = [
    AppModule::class,
    RoomModule::class]
)
interface SingletonComponent {
    fun getMemoDao(): MemoDao
}