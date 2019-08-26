package com.senijoshua.notehero.dagger.modules.uimodules

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.senijoshua.notehero.presentation.home.NotesHomeFragment
import com.senijoshua.notehero.presentation.home.NotesHomeViewModel
import dagger.Module
import dagger.Provides

/**
 * This class abstracts the provisioning of the NotesHomeViewModel
 * instance for injection in the NotesHomeFragment. This way the
 * Fragment has no details of how its View Model instance is created and supplied
 * for injection.
 * @author Seni Joshua
 */
@Module
class NotesHomeViewModelInjectionModule {

    @Provides
    fun provideNotesHomeViewModel(
        target: NotesHomeFragment,
        factory: ViewModelProvider.Factory
                                 ) = ViewModelProviders.of(target, factory).get(NotesHomeViewModel::class.java)
}