package xyz.leomurca.flickrfinder.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import xyz.leomurca.flickrfinder.data.repository.PhotoRepository
import xyz.leomurca.flickrfinder.data.repository.RemotePhotoRepository
import xyz.leomurca.flickrfinder.network.NetworkDataSource
import xyz.leomurca.flickrfinder.util.DateFormatter
import xyz.leomurca.flickrfinder.util.SystemDateFormatter

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    fun providesDateFormatter(): DateFormatter = SystemDateFormatter()

    @Provides
    fun providesPhotoRepository(
        @Dispatcher(AppDispatchers.IO) ioDispatcher: CoroutineDispatcher,
        dataSource: NetworkDataSource,
        dateFormatter: DateFormatter
    ): PhotoRepository = RemotePhotoRepository(ioDispatcher, dataSource, dateFormatter)
}