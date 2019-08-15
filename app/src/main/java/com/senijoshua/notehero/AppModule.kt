package com.senijoshua.notehero

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * Application Module responsible for instantiating and supplying application scope dependencies
 *
 * @author Seni Joshua
 */
@Module
abstract class AppModule {

    @Binds
    abstract fun provideContext(application: Application): Context

    //TODO supply retrofit, okhttp, room, shared pref by using includes of those modules i.e. RetrofitModule
}