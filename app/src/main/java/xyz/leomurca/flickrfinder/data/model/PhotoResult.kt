package xyz.leomurca.flickrfinder.data.model

sealed class PhotoResult<out T> {
    data class Success<T>(val data: T) : PhotoResult<T>()
    data class Error(val message: String) : PhotoResult<Nothing>()
}
