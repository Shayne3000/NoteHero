package com.senijoshua.notehero.data.sources.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "thumbs")
@JsonClass(generateAdapter = true)
data class Thumb(
    @PrimaryKey val id: Int,
    val description: String
)
