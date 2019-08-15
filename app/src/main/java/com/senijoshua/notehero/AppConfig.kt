package com.senijoshua.notehero

import android.app.Activity
import android.app.Application
import android.content.Context
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

/**
 * Application subclass that performs configuration and initialisation of components with application scope
 *
 * @author Seni Joshua
 */
class AppConfig : Application(), HasActivityInjector {

    @Inject lateinit var activityInjector: DispatchingAndroidInjector<Activity>

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
     * Since we'd be using Dagger to inject dependencies into Android classes,
     * we'll need to specify that the app has an activity injector. This activity injector
     * is from Dagger and will be injected by the AppComponent. It is what gets returned as the
     * injector for injecting dependencies into Android classes when activity injector is overridden.
     */
    override fun activityInjector(): AndroidInjector<Activity> = activityInjector

    companion object {
        var appInstance: Application? = null

        var appComponent: AppComponent? = null

        fun getAppContext() : Context {
            return appInstance!!.applicationContext
        }
    }
}