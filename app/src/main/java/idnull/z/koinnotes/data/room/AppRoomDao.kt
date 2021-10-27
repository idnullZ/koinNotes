package idnull.z.koinnotes.data.room

import androidx.lifecycle.LiveData
import androidx.room.*
import idnull.z.koinnotes.domain.AppNote

@Dao
interface AppRoomDao {
    @Query("SELECT * from notes_tables")
    fun getAllNotes():LiveData<List<AppNote>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert (note: AppNote)

    @Delete
    suspend fun delete(note: AppNote)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun edit(note: AppNote)

}