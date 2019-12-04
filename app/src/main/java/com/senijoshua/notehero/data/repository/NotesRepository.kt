package com.senijoshua.notehero.data.repository

import androidx.lifecycle.LiveData
import com.senijoshua.notehero.data.sources.local.dao.NoteDao
import com.senijoshua.notehero.data.sources.local.entity.Note
import com.senijoshua.notehero.data.sources.remote.ThumbRemoteDataSource
import com.senijoshua.notehero.utils.annotations.AppScope
import javax.inject.Inject

/**
 * This handles the provisioning of data from remote and local data sources to any given ViewModel.
 * In this case, it provisions a Note instance from the local DB which is
 * our single source of truth.
 *
 * @author Seni Joshua
 */
@AppScope
class NotesRepository @Inject constructor(
    private val noteDao: NoteDao,
    private val thumbRemoteSource: ThumbRemoteDataSource
) {

    suspend fun saveNote(note: Note) {
        return noteDao.insertNote(note)
    }

    suspend fun updateNote(note: Note) {
        return noteDao.updateNote(note)
    }

    suspend fun getAllNotes(): LiveData<List<Note>> {
        return noteDao.loadAllNotes()
    }

    suspend fun getNote(id: Long): LiveData<Note> {
        return noteDao.getNote(id)
    }

    suspend fun deleteNote(id: Long) {
        return noteDao.deleteNote(id)
    }

    suspend fun deleteAllNotes() {
        return noteDao.deleteAllNotes()
    }

    suspend fun getNoteThumbs() {
    }
}
