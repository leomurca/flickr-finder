package xyz.leomurca.flickrfinder.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import xyz.leomurca.flickrfinder.data.repository.PhotoRepository
import xyz.leomurca.flickrfinder.data.repository.fake.FakePhotoRepository

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {
    @Binds
    abstract fun bindsPhotoRepository(
        fakePhotoRepository: FakePhotoRepository,
    ): PhotoRepository
}