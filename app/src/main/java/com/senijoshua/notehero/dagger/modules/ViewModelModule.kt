package com.senijoshua.notehero.dagger.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.senijoshua.notehero.dagger.CustomViewModelFactory
import com.senijoshua.notehero.presentation.home.NotesHomeViewModel
import com.senijoshua.notehero.utils.annotations.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Generic module for supplying all ViewModels in the app.
 * @author Seni Joshua
 */
@Module
abstract class ViewModelModule {

    /**
     * Associate the key with the [NotesHomeViewModel] type to this provider method in the generated map
     * that the ViewModelFactory would require in order to create [ViewModel] instances.
     */
    @Binds
    @IntoMap
    @ViewModelKey(NotesHomeViewModel::class)
    abstract fun bindNotesHomeViewModel(notesHomeViewModel: NotesHomeViewModel): ViewModel

    /**
     * Denotes the [CustomViewModelFactory] class as the ViewModelProvider Factory that handles
     * [ViewModel] creation.
     */
    @Binds
    abstract fun bindViewModelFactory(factory: CustomViewModelFactory): ViewModelProvider.Factory
}
