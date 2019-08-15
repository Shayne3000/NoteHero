package com.senijoshua.notehero

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Application component responsible for injecting application scope dependencies
 *
 * @author Seni Joshua
 */
@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    AndroidInjectionLocationsModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application) : Builder
        fun build() : AppComponent
    }

    fun inject(app: AppConfig)
    //Todo remember to create subcomponents for dependencies with non-global scopes within Activities/Fragments
    //Todo Make sure the sole activity implements HasSupportFragmentInjector for injection into fragments.
}