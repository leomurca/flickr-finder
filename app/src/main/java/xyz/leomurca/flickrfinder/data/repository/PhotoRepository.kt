package xyz.leomurca.flickrfinder.data.repository

import kotlinx.coroutines.flow.Flow
import xyz.leomurca.flickrfinder.data.model.PhotoMetadata
import xyz.leomurca.flickrfinder.data.model.PhotoResult

interface PhotoRepository {
    fun search(query: String): Flow<PhotoResult<List<PhotoMetadata>>>
}