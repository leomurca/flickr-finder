package xyz.leomurca.flickrfinder.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import xyz.leomurca.flickrfinder.data.model.PhotoMetadata
import xyz.leomurca.flickrfinder.data.model.PhotoResult
import xyz.leomurca.flickrfinder.di.AppDispatchers.IO
import xyz.leomurca.flickrfinder.di.Dispatcher
import xyz.leomurca.flickrfinder.network.NetworkDataSource
import xyz.leomurca.flickrfinder.network.NetworkResult
import javax.inject.Inject

class RemotePhotoRepository @Inject constructor(
    @Dispatcher(IO) private val ioDispatcher: CoroutineDispatcher,
    private val dataSource: NetworkDataSource,
) : PhotoRepository {
    override fun search(query: String): Flow<PhotoResult<List<PhotoMetadata>>> = flow {
        when (val result = dataSource.searchPhotos(query = query)) {
            is NetworkResult.Success -> emit(
                PhotoResult.Success(
                    result.data.items.map {
                        PhotoMetadata(
                            title = it.title,
                            link = it.link,
                            media = it.media.m,
                            dateTaken = it.dateTaken,
                            description = it.description,
                            published = it.published,
                            author = it.author,
                            authorId = it.authorId,
                            tags = it.tags.split(" ")
                        )
                    }
                )
            )

            is NetworkResult.Error -> emit(
                PhotoResult.Error(result.exception.message)
            )
        }
    }.flowOn(ioDispatcher)
}