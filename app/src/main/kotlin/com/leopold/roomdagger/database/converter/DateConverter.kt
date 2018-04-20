package com.leopold.roomdagger.database.converter

import android.arch.persistence.room.TypeConverter
import java.util.*

/**
 * @author Leopold
 */
@Suppress("UNUSED")
class DateConverter {

    @TypeConverter
    fun toDate(value: Long): Date {
        return Date(value)
    }

    @TypeConverter
    fun toLong(date: Date): Long {
        return date.time
    }

}