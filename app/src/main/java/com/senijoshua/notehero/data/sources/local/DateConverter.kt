package com.senijoshua.notehero.data.sources.local

import androidx.room.TypeConverter
import java.util.Date

/**
 * This converts from the Date data type to the long type.
 * The latter of which can be persisted in a Room DB.
 * @author Seni Joshua
 */
class DateConverter {

    @TypeConverter
    fun toDate(value: Long): Date = Date(value)

    @TypeConverter
    fun toTimeStamp(date: Date): Long = date.time
}
