package com.senijoshua.notehero.data.sources.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.senijoshua.notehero.data.sources.local.DateConverter
import java.util.Date

/**
 * Definition of local-sourced data
 * An entity class from which the Notes table is created.
 * @author Seni Joshua
 */
@Entity(tableName = "notes")
@TypeConverters(DateConverter::class)
data class Note(
    @PrimaryKey val id: Int,
    val lastModified: Date,
    val reminder: String?,
    val backgroundColor: Int,
    val isReminder: Boolean,
    val isPinned: Boolean,
    val isTrashed: Boolean,
    val isInVault: Boolean
)
