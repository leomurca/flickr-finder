package xyz.leomurca.flickrfinder.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import xyz.leomurca.flickrfinder.network.model.NetworkPhotosResponse

interface ApiService {

    @GET("photos_public.gne")
    suspend fun searchPhotos(
        @Query("format") format: String = "json",
        @Query("nojsoncallback") noJsonCallback: String = "1",
        @Query("tags") tags: String,
    ): Response<NetworkPhotosResponse>
}