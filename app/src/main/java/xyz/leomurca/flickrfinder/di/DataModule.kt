package xyz.leomurca.flickrfinder.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import xyz.leomurca.flickrfinder.data.repository.PhotoRepository
import xyz.leomurca.flickrfinder.data.repository.RemotePhotoRepository
import xyz.leomurca.flickrfinder.network.NetworkDataSource

@Module
@InstallIn(SingletonComponent::class)
class DataModule {
    @Provides
    fun providesPhotoRepository(
        @Dispatcher(AppDispatchers.IO) ioDispatcher: CoroutineDispatcher,
        dataSource: NetworkDataSource,
    ): PhotoRepository = RemotePhotoRepository(ioDispatcher, dataSource)
}