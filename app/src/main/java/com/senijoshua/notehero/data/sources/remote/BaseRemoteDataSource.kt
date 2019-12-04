package com.senijoshua.notehero.data.sources.remote

import android.util.Log
import com.senijoshua.notehero.data.sources.DataResource
import kotlinx.coroutines.CancellationException
import retrofit2.Response

private const val CANCELLATION_EXCEPTION = "CancellationException"

/**
 * This is the base class for a wrapper over any retrofit interface
 * which provides the structure for provisioning data from a remote
 * service and the means for handling any errors that might occur in the process.
 *
 * @author Seni Joshua
 */
abstract class BaseRemoteDataSource {

    protected suspend fun <T> getResponse(networkCall: suspend () -> Response<T>):
        DataResource<T> {
        try {
            val response = networkCall()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return DataResource.success(body)
            }
            return responseError(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            // TODO in ViewModel, do nothing if the exception is Cancellation Exception
            //  but instead use the DB's data.
            if (e is CancellationException) return responseError(CANCELLATION_EXCEPTION)

            return responseError(e.message ?: Log.getStackTraceString(e as Throwable))
        }
    }

    private fun <T> responseError(errorMessage: String): DataResource<T> {
        return DataResource.error("Network call failure: $errorMessage")
    }
}
