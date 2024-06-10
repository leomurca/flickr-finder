package xyz.leomurca.flickrfinder.data.repository.fake

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import xyz.leomurca.flickrfinder.data.model.PhotoMetadata
import xyz.leomurca.flickrfinder.data.repository.PhotoRepository
import xyz.leomurca.flickrfinder.di.AppDispatchers.IO
import xyz.leomurca.flickrfinder.di.Dispatcher
import javax.inject.Inject

class FakePhotoRepository @Inject constructor(
    @Dispatcher(IO) private val ioDispatcher: CoroutineDispatcher,
) : PhotoRepository {

    override fun search(keywords: List<String>): Flow<List<PhotoMetadata>> {
        return flow {
            emit(
                listOf(
                    PhotoMetadata(
                        title = "Porcupine in A Tree",
                        link = "https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/",
                        media = "https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg",
                        dateTaken = "May 12, 2024",
                        description = " <p><a href=\"https://www.flickr.com/people/zoomzoomslittleadventures/\">ZoomZoom Du Buisson</a> posted a photo:</p> <p><a href=\"https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/\" title=\"Porcupine in A Tree\"><img src=\"https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg\" width=\"240\" height=\"160\" alt=\"Porcupine in A Tree\" /></a></p> ",
                        published = "June 4, 2024",
                        author = "nobody@flickr.com (\"ZoomZoom Du Buisson\")",
                        authorId = "197381316@N02",
                        tags = listOf("maine", "wildlife", "nature", "outdoor", "spring", "outside", "porcupine", "tree")
                    ),
                    PhotoMetadata(
                        title = "Porcupine in A Tree",
                        link = "https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/",
                        media = "https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg",
                        dateTaken = "May 12, 2024",
                        description = " <p><a href=\"https://www.flickr.com/people/zoomzoomslittleadventures/\">ZoomZoom Du Buisson</a> posted a photo:</p> <p><a href=\"https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/\" title=\"Porcupine in A Tree\"><img src=\"https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg\" width=\"240\" height=\"160\" alt=\"Porcupine in A Tree\" /></a></p> ",
                        published = "June 4, 2024",
                        author = "nobody@flickr.com (\"ZoomZoom Du Buisson\")",
                        authorId = "197381316@N02",
                        tags = listOf("maine", "wildlife", "nature", "outdoor", "spring", "outside", "porcupine", "tree")
                    ),
                    PhotoMetadata(
                        title = "Porcupine in A Tree",
                        link = "https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/",
                        media = "https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg",
                        dateTaken = "May 12, 2024",
                        description = " <p><a href=\"https://www.flickr.com/people/zoomzoomslittleadventures/\">ZoomZoom Du Buisson</a> posted a photo:</p> <p><a href=\"https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/\" title=\"Porcupine in A Tree\"><img src=\"https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg\" width=\"240\" height=\"160\" alt=\"Porcupine in A Tree\" /></a></p> ",
                        published = "June 4, 2024",
                        author = "nobody@flickr.com (\"ZoomZoom Du Buisson\")",
                        authorId = "197381316@N02",
                        tags = listOf("maine", "wildlife", "nature", "outdoor", "spring", "outside", "porcupine", "tree")
                    ),
                    PhotoMetadata(
                        title = "Porcupine in A Tree",
                        link = "https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/",
                        media = "https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg",
                        dateTaken = "May 12, 2024",
                        description = " <p><a href=\"https://www.flickr.com/people/zoomzoomslittleadventures/\">ZoomZoom Du Buisson</a> posted a photo:</p> <p><a href=\"https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/\" title=\"Porcupine in A Tree\"><img src=\"https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg\" width=\"240\" height=\"160\" alt=\"Porcupine in A Tree\" /></a></p> ",
                        published = "June 4, 2024",
                        author = "nobody@flickr.com (\"ZoomZoom Du Buisson\")",
                        authorId = "197381316@N02",
                        tags = listOf("maine", "wildlife", "nature", "outdoor", "spring", "outside", "porcupine", "tree")
                    ),
                    PhotoMetadata(
                        title = "Porcupine in A Tree",
                        link = "https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/",
                        media = "https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg",
                        dateTaken = "May 12, 2024",
                        description = " <p><a href=\"https://www.flickr.com/people/zoomzoomslittleadventures/\">ZoomZoom Du Buisson</a> posted a photo:</p> <p><a href=\"https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/\" title=\"Porcupine in A Tree\"><img src=\"https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg\" width=\"240\" height=\"160\" alt=\"Porcupine in A Tree\" /></a></p> ",
                        published = "June 4, 2024",
                        author = "nobody@flickr.com (\"ZoomZoom Du Buisson\")",
                        authorId = "197381316@N02",
                        tags = listOf("maine", "wildlife", "nature", "outdoor", "spring", "outside", "porcupine", "tree")
                    ),
                    PhotoMetadata(
                        title = "Porcupine in A Tree",
                        link = "https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/",
                        media = "https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg",
                        dateTaken = "May 12, 2024",
                        description = " <p><a href=\"https://www.flickr.com/people/zoomzoomslittleadventures/\">ZoomZoom Du Buisson</a> posted a photo:</p> <p><a href=\"https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/\" title=\"Porcupine in A Tree\"><img src=\"https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg\" width=\"240\" height=\"160\" alt=\"Porcupine in A Tree\" /></a></p> ",
                        published = "June 4, 2024",
                        author = "nobody@flickr.com (\"ZoomZoom Du Buisson\")",
                        authorId = "197381316@N02",
                        tags = listOf("maine", "wildlife", "nature", "outdoor", "spring", "outside", "porcupine", "tree")
                    ),
                )
            )
        }.flowOn(ioDispatcher)
    }
}