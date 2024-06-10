package xyz.leomurca.flickrfinder.data.repository

import kotlinx.coroutines.flow.Flow
import xyz.leomurca.flickrfinder.data.model.PhotoMetadata

interface PhotoRepository {
    fun search(keywords: List<String>): Flow<List<PhotoMetadata>>
}