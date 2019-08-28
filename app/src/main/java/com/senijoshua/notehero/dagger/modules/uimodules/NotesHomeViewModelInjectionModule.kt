package com.senijoshua.notehero.dagger.modules.uimodules

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.senijoshua.notehero.presentation.home.NotesHomeFragment
import com.senijoshua.notehero.presentation.home.NotesHomeViewModel
import dagger.Module
import dagger.Provides

/**
 * This class abstracts the creation of the NotesHomeViewModel instance
 * through the provider since we've opted to inject the instance in the NotesHomeFragment
 * directly rather than create it in the class as usual. This way, the Fragment has no
 * idea how its View Model instance is instantiated and supplied for injection.
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
