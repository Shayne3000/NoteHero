package com.senijoshua.notehero.dagger.modules

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.senijoshua.notehero.data.sources.local.AppDatabase
import com.senijoshua.notehero.data.sources.local.AppDatabase.Companion.DATABASE_NAME
import com.senijoshua.notehero.data.sources.local.AppDatabase.Companion.MIGRATION_1_2
import com.senijoshua.notehero.data.sources.local.dao.NoteDao
import com.senijoshua.notehero.utils.annotations.AppScope
import dagger.Module
import dagger.Provides

/**
 * Application Module responsible for instantiating and supplying application scope dependencies
 *
 * @author Seni Joshua
 */
@Module(includes = [ViewModelModule::class, NetworkModule::class])
class AppModule {

    @AppScope
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @AppScope
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
            .addMigrations(MIGRATION_1_2).build()
    }

    @AppScope
    @Provides
    fun provideNoteDao(database: AppDatabase): NoteDao {
        return database.getNoteDao()
    }
}
