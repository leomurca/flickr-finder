package xyz.leomurca.flickrfinder.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import xyz.leomurca.flickrfinder.data.model.PhotoMetadata
import xyz.leomurca.flickrfinder.data.model.PhotoResult
import xyz.leomurca.flickrfinder.data.repository.PhotoRepository

class TestPhotoRepository : PhotoRepository {
    private val photoResultFlow = MutableSharedFlow<PhotoResult<List<PhotoMetadata>>>()
    override fun search(query: String): Flow<PhotoResult<List<PhotoMetadata>>> = photoResultFlow
    suspend fun sendPhotoResult(photoResult: PhotoResult<List<PhotoMetadata>>) {
        photoResultFlow.emit(photoResult)
    }
}