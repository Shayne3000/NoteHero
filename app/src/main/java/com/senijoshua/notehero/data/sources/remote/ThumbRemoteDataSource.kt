package com.senijoshua.notehero.data.sources.remote

import javax.inject.Inject

/**
 * This class is a wrapper over the ThumbApi Retrofit Interface
 * that provisions Thumbnails from the remote Unsplash
 * service through the ThumbApi and handles any errors that might occur in the process.
 *
 * @author Seni Joshua
 */
class ThumbRemoteDataSource @Inject constructor(private val thumbRemoteService: ThumbApi) :
    BaseRemoteDataSource() {

    suspend fun getThumbnails(pageNumber: Int, itemsPerPage: Int) =
        getResponse { thumbRemoteService.getPhotos(pageNumber, itemsPerPage) }
}
