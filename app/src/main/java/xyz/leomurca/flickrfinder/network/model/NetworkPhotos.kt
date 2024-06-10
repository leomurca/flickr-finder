package xyz.leomurca.flickrfinder.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPhotos(
    val title: String,
    val link: String,
    val media: NetworkMedia,
    val description: String,
    val published: String,
    val author: String,
    val tags: String,
    @SerialName("date_taken") val dateTaken: String,
    @SerialName("author_id") val authorId: String,
)
