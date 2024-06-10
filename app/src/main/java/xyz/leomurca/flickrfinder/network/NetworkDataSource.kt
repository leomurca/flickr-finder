package xyz.leomurca.flickrfinder.network

import xyz.leomurca.flickrfinder.network.model.NetworkPhotosResponse

interface NetworkDataSource {
    suspend fun searchPhotos(query: String): NetworkResult<NetworkPhotosResponse>
}