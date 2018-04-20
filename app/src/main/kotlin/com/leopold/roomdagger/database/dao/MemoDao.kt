package com.leopold.roomdagger.database.dao

import android.arch.persistence.room.*
import com.leopold.roomdagger.database.entity.Memo
import io.reactivex.Flowable

/**
 * @author Leopold
 */
@Dao
interface MemoDao {

    @Query("SELECT * FROM Memo")
    fun getMemos(): Flowable<List<Memo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memo: Memo)

    @Delete
    fun delete(memo: Memo)

    @Query("DELETE FROM Memo")
    fun deleteAll()

}