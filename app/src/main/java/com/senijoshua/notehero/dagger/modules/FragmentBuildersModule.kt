package com.senijoshua.notehero.dagger.modules

import com.senijoshua.notehero.dagger.modules.uimodules.NotesHomeViewModelInjectionModule
import com.senijoshua.notehero.presentation.home.NotesHomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This lists the Fragments in which an AndroidInjector instance will be generated
 * used to handle dependency injection.
 * @author Seni Joshua
 */
@Module
abstract class FragmentBuildersModule {

    /**
     * This [NotesHomeViewModelInjectionModule] is added to the sub-component generated
     * for the [NotesHomeFragment] instance which then injects the supplied
     * NotesHomeViewModel dependency into said Fragment using the AndroidInjector interface.
     */
    @ContributesAndroidInjector(modules = [NotesHomeViewModelInjectionModule::class])
    abstract fun contributeNotesHomeFragment(): NotesHomeFragment
}
