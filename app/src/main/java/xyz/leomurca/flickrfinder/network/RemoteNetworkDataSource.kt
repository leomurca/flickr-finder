package xyz.leomurca.flickrfinder.network

import xyz.leomurca.flickrfinder.network.model.NetworkPhotosResponse
import javax.inject.Inject

class RemoteNetworkDataSource @Inject constructor(
    private val apiService: ApiService,
) : NetworkDataSource {
    override suspend fun searchPhotos(query: String): NetworkResult<NetworkPhotosResponse> {
        return try {
            val response = apiService.searchPhotos(tags = query)

            if (response.isSuccessful) {
                NetworkResult.Success(response.body() ?: throw Exception("Empty response body!"))
            } else {
                NetworkResult.Error(NetworkResult.NetworkException.UnknownException("Something went wrong!"))
            }
        } catch (e: Exception) {
            NetworkResult.Error(NetworkResult.NetworkException.UnknownException(e.message.toString(), e))
        }
    }
}