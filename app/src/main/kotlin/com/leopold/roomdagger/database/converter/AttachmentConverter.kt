package com.leopold.roomdagger.database.converter

import android.arch.persistence.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.leopold.roomdagger.database.column.Attachment

/**
 * @author Leopold
 */
@Suppress("UNUSED")
class AttachmentConverter {

    @TypeConverter
    fun toAttachments(value: String): ArrayList<Attachment> {
        return Gson().fromJson(value, object : TypeToken<ArrayList<Attachment>>() {}.type)
    }

    @TypeConverter
    fun toString(attachments: ArrayList<Attachment>): String {
        return Gson().toJson(attachments)
    }
}