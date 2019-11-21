package com.senijoshua.notehero.data.sources

/**
 * This is an abstraction of data types from both the DB and the remote service
 * that provides a unified interface for assessing UI-related data
 * and its loading status within the View.
 *
 * The data is returned along with its fetch status within a [LiveData] observable
 * as LiveData<DataResource<T>> by the repository.
 *
 * @author Seni Joshua
 */
data class DataResource<out T>(val status: Status, val data: T?, val message:  String?) {

    companion object {
        fun <T> loading(data: T? = null): DataResource<T> {
            return DataResource(Status.LOADING, data, null)
        }

        fun <T> success(data: T): DataResource<T> {
            return DataResource(Status.SUCCESS, data, null)
        }

        fun <T> error(message: String, data: T? = null): DataResource<T> {
            return DataResource(Status.ERROR, data, message)
        }
    }

    enum class Status {
        LOADING,
        SUCCESS,
        ERROR
    }
}
