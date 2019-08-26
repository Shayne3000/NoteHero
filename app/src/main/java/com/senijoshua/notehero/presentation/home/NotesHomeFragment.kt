package com.senijoshua.notehero.presentation.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.senijoshua.notehero.presentation.base.NoteHeroFragment
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class NotesHomeFragment : NoteHeroFragment() {
    @Inject lateinit var viewModel: NotesHomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
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