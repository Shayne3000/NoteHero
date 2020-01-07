package com.senijoshua.notehero.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.senijoshua.notehero.R
import com.senijoshua.notehero.data.sources.local.entity.Note
import com.senijoshua.notehero.presentation.base.NoteHeroFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class NotesHomeFragment : NoteHeroFragment(R.layout.fragment_notes_home) {
    @Inject
    lateinit var viewModel: NotesHomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        viewModel.activeNotes.observe(this, notesListObserver)
    }

    val notesListObserver = Observer<List<Note>> {
        // update the RecyclerView adapter with the returned list
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        navController.navigate(R.id.note_details_fragment)
        // callback for after the layout has been inflated
        // perform setup of UI elements e.g Toolbar and button here after the layout has been inflated.
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
