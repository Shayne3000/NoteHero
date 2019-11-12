package com.senijoshua.notehero.data.sources.remote

import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit interface that lists the REST API
 * endpoints for Unsplash's photo service
 * @author Seni Joshua
 */
interface NotesThumbRemote {

    @GET("/photos")
    fun getThumbPhotos(@Query("page") pageNumber: Int = 1,
                       @Query("per_page") itemsPerPage: Int = 20,
                       @Query("order_by") order: String = "popular")
}

