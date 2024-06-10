package xyz.leomurca.flickrfinder.network.model

import kotlinx.serialization.Serializable

@Serializable
data class NetworkPhotosResponse(
    val title: String,
    val link: String,
    val items: List<NetworkPhotos>,
)
