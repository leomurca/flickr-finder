package xyz.leomurca.flickrfinder.ui.details

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Test
import xyz.leomurca.flickrfinder.data.model.PhotoMetadata

class DetailsViewModelTest {

    private val viewModel = DetailsViewModel()

    @Test
    fun `when load ViewModel then ui state is null`() = runTest {
        // Assert
        assertEquals(null, viewModel.uiState.value)
    }

    @Test
    fun `when set photo then ui state is not null`() = runTest {
        // Arrange
        val photoMetadata = PhotoMetadata(
            title = "Porcupine in A Tree",
            link = "https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/",
            media = "https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg",
            dateTaken = "May 12, 2024",
            description = " <p><a href=\"https://www.flickr.com/people/zoomzoomslittleadventures/\">ZoomZoom Du Buisson</a> posted a photo:</p> <p><a href=\"https://www.flickr.com/photos/zoomzoomslittleadventures/53769361124/\" title=\"Porcupine in A Tree\"><img src=\"https://live.staticflickr.com/65535/53769361124_4f4e902d92_m.jpg\" width=\"240\" height=\"160\" alt=\"Porcupine in A Tree\" /></a></p> ",
            published = "June 4, 2024",
            author = "nobody@flickr.com (\"ZoomZoom Du Buisson\")",
            authorId = "197381316@N02",
            tags = listOf("maine", "wildlife", "nature", "outdoor", "spring", "outside", "porcupine", "tree")
        )

        // Act
        viewModel.setCurrentPhoto(photoMetadata)

        // Assert
        assertEquals(photoMetadata, viewModel.uiState.value)
    }
}