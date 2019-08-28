package com.senijoshua.notehero.dagger.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.senijoshua.notehero.data.sources.local.AppDatabase
import com.senijoshua.notehero.data.sources.local.AppDatabase.Companion.DATABASE_NAME
import com.senijoshua.notehero.data.sources.local.dao.NoteDao
import com.senijoshua.notehero.utils.annotations.AppScope
import dagger.Module
import dagger.Provides

/**
 * Application Module responsible for instantiating and supplying application scope dependencies
 *
 * @author Seni Joshua
 */
@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @AppScope
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    @AppScope
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME).build()
    }

    @Provides
    @AppScope
    fun provideNoteDao(database: AppDatabase): NoteDao {
        return database.getNoteDao()
    }
    // TODO supply retrofit, okhttp, room, shared pref by using includes of those modules i.e. RetrofitModule
}
