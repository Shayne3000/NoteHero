package com.senijoshua.notehero.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.senijoshua.notehero.data.repository.NotesRepository
import com.senijoshua.notehero.data.sources.local.entity.Note
import javax.inject.Inject
import kotlinx.coroutines.launch

/**
 * This class stores and manages data related to the Notes Home fragment i.e. list of all visible notes
 * provisioned by the repository and it facilitates the update of the view with new data as
 * the View is subscribed to its LiveData observable in order to react to changes in the held data when in an active state
 *@author Seni Joshua
 */
class NotesHomeViewModel @Inject constructor(private val notesRepository: NotesRepository) :
    ViewModel() {

    private val mutableNotes: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>().also {
            loadAllNotes()
        }
    }

    val activeNotes: LiveData<List<Note>> = mutableNotes

    /**
     * This function starts a coroutine that will load all
     * active notes from the DB.
     * NB: This is main safe
     */
    private fun loadAllNotes() {
        viewModelScope.launch {
            notesRepository.getAllNotes()
        }
    }
}
