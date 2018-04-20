package com.leopold.roomdagger.database.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.arch.persistence.room.TypeConverters
import com.leopold.roomdagger.database.column.Attachment
import com.leopold.roomdagger.database.converter.AttachmentConverter
import com.leopold.roomdagger.database.converter.DateConverter
import java.util.*

/**
 * @author Leopold
 */
@Entity(tableName = "Memo")
@TypeConverters(AttachmentConverter::class, DateConverter::class)
data class Memo(
        @PrimaryKey(autoGenerate = true)
        val id: Int = 0,

        @ColumnInfo(name = "title")
        val title: String,

        @ColumnInfo(name = "content")
        val content: String,

        @ColumnInfo(name = "attachments")
        val attachments: ArrayList<Attachment>,

        @ColumnInfo(name = "created")
        val created: Date,

        @ColumnInfo(name = "modified")
        val modified: Date
)