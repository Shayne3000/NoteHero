package com.senijoshua.notehero.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.senijoshua.notehero.data.sources.DataResource
import kotlinx.coroutines.Dispatchers

/**
 * This class facilitates the single source of truth strategy
 * with the local DB as the source of truth for the rest of the app
 * which helps to avoid inconsistencies in data.
 *
 * The strategy is thus- whenever data is requested, the local DB copy will be returned
 * in a LiveData then a request to fetch data from the remote service will be triggered
 * and the response will be saved in the database, which will then notify any subscribed observers
 * about the changes to the DBs data.
 *
 * @author Seni Joshua
 */
object DataSourceManager {

    /**
     * This function kick starts a mechanism that takes data from
     * the DB lookup and the network call represented by normal data type [T] and
     * DataResource-wrapped [A] respectively and following the Single source of truth pattern,
     * returns a DataResource-wrapped [T] to the UI.
     */
    fun <T, A> dataFromSourceAsLiveData(
        databaseQuery: suspend () -> LiveData<T>,
        networkCall: suspend () -> DataResource<A>,
        saveNetworkCallResult: suspend (A) -> Unit
    ): LiveData<DataResource<T>> =
        liveData(Dispatchers.IO) {
            emit(DataResource.loading())

            val localData = databaseQuery.invoke().map { DataResource.success(it) }
            emitSource(localData)

            val remoteData = networkCall.invoke()
            if (remoteData.status == DataResource.Status.SUCCESS) {
                saveNetworkCallResult(remoteData.data!!)
            } else if (remoteData.status == DataResource.Status.ERROR) {
                emit(DataResource.error(remoteData.message!!))
                emitSource(localData)
            }
        }
    // TODO it's a good practice to pass the ViewModelScope context here
    // so that when the ViewModelScope is cleared it can help terminate
    // the currently running job in the liveData coroutine here. This is
    // shown here: https://stackoverflow.com/questions/57150408/
    // should-i-pass-viewmodelscope-coroutinecontext-to-livedata-builder-function
}
