package com.senijoshua.notehero.data.sources.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.senijoshua.notehero.data.sources.local.entity.Note

/**
 * The class is responsible for retrieving entities from the DB
 * and persisting changes to said entities back into the DB.
 * @author Seni Joshua
 */
@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertNote(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateNote(note: Note)

    @Query("SELECT * FROM notes WHERE notes.id = :id")
    fun getNote(id: Long): LiveData<Note>

    @Query("SELECT * FROM notes")
    fun loadAllNotes(): LiveData<List<Note>>

    @Query("DELETE FROM notes WHERE id = :id")
    fun deleteNote(id: Long)

    @Query("DELETE FROM notes")
    fun deleteAllNotes()
}
