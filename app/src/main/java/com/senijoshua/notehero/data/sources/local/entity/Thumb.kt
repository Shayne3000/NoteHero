package com.senijoshua.notehero.data.sources.local.entity

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@Entity(tableName = "thumbs")
@JsonClass(generateAdapter = true)
data class Thumb(
    @PrimaryKey val id: Int,
    val description: String = "",
    @Embedded val user: User,
    @Embedded val urls: Urls
)

data class User(@ColumnInfo(name = "thumb_creator_id") val id: String = "",
                @ColumnInfo(name = "thumb_name") val name: String = "",
                val portfolio_url: String = "",
                val instagram_username: String = ""
                )

data class Urls(@ColumnInfo(name = "full_image") val full: String = "",
                @ColumnInfo(name = "regular_image") val regular: String = "",
                @ColumnInfo(name = "small_image") val small: String = "",
                @ColumnInfo(name = "thumb_image") val thumb: String = ""
               )
