package com.senijoshua.notehero

import com.senijoshua.notehero.presentation.base.RootActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This lists the Android classes in which dependencies will be injected
 *
 * @author Seni Joshua
 */
@Module
abstract class AndroidInjectionLocationsModule {

    /**
     * Denotes this class as a location where the underlying subcomponent
     * will generate an AndroidInjector to perform field injection
     */
    @ContributesAndroidInjector
    abstract fun provideRootActivity(): RootActivity
}
