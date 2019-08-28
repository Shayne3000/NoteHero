package com.senijoshua.notehero.dagger.modules

import com.senijoshua.notehero.presentation.base.NoteHeroActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * This lists the Activities in which an AndroidInjector instance is used to perform dependency injection
 * @author Seni Joshua
 */
@Module
abstract class ActivityBuildersModule {

    /**
     * Denotes the [NoteHeroActivity] as a location in which an AndroidInjector will be generated
     * with a subcomponent to perform field injection
     */
    @ContributesAndroidInjector
    abstract fun contributeRootActivity(): NoteHeroActivity
}
