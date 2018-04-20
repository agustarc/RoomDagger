package com.leopold.roomdagger.database

import android.arch.persistence.db.SupportSQLiteDatabase
import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.migration.Migration
import android.content.Context
import com.leopold.roomdagger.database.AppDatabase.Companion.DB_VERSION
import com.leopold.roomdagger.database.dao.MemoDao
import com.leopold.roomdagger.database.entity.Memo

/**
 * @author Leopold
 */
@Database(entities = [Memo::class], version = DB_VERSION, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getMemoDao(): MemoDao

    companion object {
        const val DB_VERSION = 1
        private const val DB_NAME = "roomdagger.db"
        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: build(context).also { INSTANCE = it }
                }

        private fun build(context: Context) = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, DB_NAME)
                .addMigrations(MIGRATION_1_TO_2, MIGRATION_2_TO_3)
                .build()

        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }

        private val MIGRATION_2_TO_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {

            }
        }
    }
}