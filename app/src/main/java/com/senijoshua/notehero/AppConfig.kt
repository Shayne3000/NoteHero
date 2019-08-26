package com.senijoshua.notehero

import android.app.Application
import android.content.Context
import com.senijoshua.notehero.dagger.components.AppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

/**
 * Application subclass that performs configuration and initialisation of components with application scope
 *
 * @author Seni Joshua
 */
class AppConfig : Application(), HasAndroidInjector {
    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        initialise()
    }

    private fun initialise() {
        appInstance = this
        appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent?.inject(this)
    }

    /**
     * In order to inject dependencies into Android classes, Dagger's AndroidInjector API can be used as it is used to
     * perform field injection for Activities, Fragments, BroadcastReceiver, and Services. It is injected here by the
     * AppComponent and is what gets returned as the injector for performing injection for the component Activity
     * when the androidinjector method is overridden.
     */
    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    companion object {
        var appInstance: Application? = null

        var appComponent: AppComponent? = null

        fun getAppContext(): Context {
            return appInstance!!.applicationContext
        }
    }
}
