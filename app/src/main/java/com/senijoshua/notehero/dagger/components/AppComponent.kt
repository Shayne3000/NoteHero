package com.senijoshua.notehero.dagger.components

import android.app.Application
import com.senijoshua.notehero.AppConfig
import com.senijoshua.notehero.dagger.modules.ActivityBuildersModule
import com.senijoshua.notehero.dagger.modules.AppModule
import com.senijoshua.notehero.utils.annotations.AppScope
import com.senijoshua.notehero.utils.glide.NoteHeroGlideModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

/**
 * Application component responsible for injecting application scope dependencies
 *
 * @author Seni Joshua
 */
@AppScope
@Component(
    modules = [
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuildersModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AppConfig)
    fun inject(glideModule: NoteHeroGlideModule)
    // Todo remember to create subcomponents for dependencies with non-global scopes within Activities/Fragments
}
