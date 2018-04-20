package com.leopold.roomdagger.database

import com.leopold.roomdagger.App
import com.leopold.roomdagger.database.dao.MemoDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Leopold
 */
@Module
class RoomModule {

    @Provides
    @Singleton
    fun provideAppDatabase(app: App): AppDatabase {
        return AppDatabase.getInstance(app)
    }

    @Provides
    @Singleton
    fun provideMemoDao(db: AppDatabase): MemoDao {
        return db.getMemoDao()
    }
}