package com.senijoshua.notehero.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.senijoshua.notehero.presentation.base.NoteHeroFragment

class NotesHomeFragment : NoteHeroFragment() {
//instantiate and supply a ViewModelFactory (which would create a ViewModel) in the AppModule
    //and create it here using a ViewModelProvider. This may also allow injection in this ViewModel.

    override fun onCreate(savedInstanceState: Bundle?) {
        //field injection can be done here with the AndroidInjector
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
                             ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        //field injection can be also done here
        super.onAttach(context)
    }
}