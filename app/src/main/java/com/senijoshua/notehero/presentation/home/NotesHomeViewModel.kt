package com.senijoshua.notehero.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.senijoshua.notehero.data.repository.NotesRepository
import com.senijoshua.notehero.data.sources.local.entity.Note
import javax.inject.Inject

/**
 * This class stores and manages data related to the Notes Home fragment i.e. list of all visible notes
 * provisioned by the repository and it facilitates the update of the view with new data as
 * the View is subscribed to its LiveData observable in order to react to changes in the held data when in foreground
 *@author Seni Joshua
 */
class NotesHomeViewModel @Inject constructor(val notesRepository: NotesRepository) : ViewModel() {

    private val notes: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>().also {
            loadAllNotes()
        }
    }

    fun getNotes(): LiveData<List<Note>> {
        return notes
    }

    private fun loadAllNotes() {
        // TODO Do an asynchronous operation using coroutines to fetch notes from the Room DB.
    }
}