package com.senijoshua.notehero.data.sources.remote

import com.senijoshua.notehero.data.sources.local.entity.Thumb
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Retrofit interface that lists the REST API
 * endpoints for Unsplash's photo service
 * @author Seni Joshua
 */
interface ThumbRemote {

    @GET("/photos")
    suspend fun getThumbnails(@Query("page") pageNumber: Int = 1,
                      @Query("per_page") itemsPerPage: Int = 20,
                              @Query("order_by") order: String = "popular"
                             ): Response<List<Thumb>>
}
