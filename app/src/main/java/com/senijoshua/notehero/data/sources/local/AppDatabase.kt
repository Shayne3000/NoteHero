package com.senijoshua.notehero.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.senijoshua.notehero.data.sources.local.dao.NoteDao
import com.senijoshua.notehero.data.sources.local.entity.Note

/**
 * This represents the app's Database with its inherent components and configuration.
 * It lists the various entities and DAOs contained in the DB.
 * @author Seni Joshua
 */
@Database(entities = [Note::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // TODO Remember to implement a migration to newer DB versions and removed the exportSchema

    abstract fun getNoteDao(): NoteDao

    companion object {
        const val DATABASE_NAME = "notehero_db.db"

        val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // since there is no schema change, do nothing.
            }
        }
    }
}
