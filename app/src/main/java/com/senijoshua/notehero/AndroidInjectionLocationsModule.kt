package com.senijoshua.notehero

import com.senijoshua.notehero.presentation.RootActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This lists the Android classes in which dependencies will be injected
 *
 * @author Seni Joshua
 */
@Module
abstract class AndroidInjectionLocationsModule {

    @ContributesAndroidInjector
    abstract fun provideRootActivity(): RootActivity
}
