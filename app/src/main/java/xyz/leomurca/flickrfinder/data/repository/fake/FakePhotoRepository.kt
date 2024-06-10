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
                        media = "https://live.staticflickr.com/65535/53762634202_b9bd80c596_m.jpg",
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
                        media = "https://live.staticflickr.com/65535/53758695904_4954b2d59f_m.jpg",
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
                        media = "https://live.staticflickr.com/65535/53758182531_6231126679_m.jpg",
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
                        media = "https://live.staticflickr.com/65535/53758243558_64630004a4_m.jpg",
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
                        media = "https://live.staticflickr.com/65535/53756275486_1bbd31321a_m.jpg",
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
                        media = "https://live.staticflickr.com/65535/53756195596_9915115f0d_m.jpg",
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
                        media = "https://live.staticflickr.com/65535/53754473281_6f6deb7ac3_m.jpg",
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
                        media = "https://live.staticflickr.com/65535/53754887850_6b7ebd227a_m.jpg",
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
                        media = "https://live.staticflickr.com/65535/53751911656_ac08a4a0cd_m.jpg",
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
                        media = "https://live.staticflickr.com/65535/53752323385_d7dc1a9853_m.jpg",
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
                        media = "https://live.staticflickr.com/65535/53749377942_545fd080df_m.jpg",
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