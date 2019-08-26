package com.senijoshua.notehero.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.senijoshua.notehero.data.sources.local.entity.Note
import com.senijoshua.notehero.data.sources.local.dao.NoteDao

/**
 * This represents the app's Database with its inherent components and configuration.
 * @author Seni Joshua
 */
@Database(entities = [Note::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    // TODO Remember to implement a migration to newer DB versions and removed the exportSchema

    abstract fun getNoteDao(): NoteDao

    companion object {
        const val DATABASE_NAME = "notehero_db.db"
    }
}
