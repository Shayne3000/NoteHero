package com.senijoshua.notehero.data.sources.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.senijoshua.notehero.data.sources.local.entity.Note

/**
 * The interface is responsible for retrieving entities from the DB
 * and persisting changes to said entities back into the DB.
 * @author Seni Joshua
 */
@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    @Query("SELECT * FROM notes WHERE notes.id = :id")
    suspend fun getNote(id: Long): LiveData<Note>

    @Query("SELECT * FROM notes")
    suspend fun loadAllNotes(): LiveData<List<Note>>

    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun deleteNote(id: Long)

    @Query("DELETE FROM notes")
    suspend fun deleteAllNotes()
}
