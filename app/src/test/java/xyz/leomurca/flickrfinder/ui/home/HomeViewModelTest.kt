package xyz.leomurca.flickrfinder.ui.home

import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import xyz.leomurca.flickrfinder.MainDispatcherRule
import xyz.leomurca.flickrfinder.data.TestPhotoRepository
import xyz.leomurca.flickrfinder.data.model.PhotoMetadata
import xyz.leomurca.flickrfinder.data.model.PhotoResult

class HomeViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val photoRepository = TestPhotoRepository()

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        viewModel = HomeViewModel(photoRepository)
    }

    @Test
    fun `when load ViewModel - then ui state is Loading`() = runTest {
        // Assert
        assertEquals(HomeViewModel.UiState.Loading, viewModel.uiState.value)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @Test
    fun `when loads ViewModel and receive not empty Success Photo Result - then ui state is PopulatedState`() =
        runTest {
            // Arrange
            val photoResult = PhotoResult.Success(
                data = listOf(
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
                    )
                )
            )

            // Act
            photoRepository.sendPhotoResult(photoResult)

            // Assert
            assertEquals(HomeViewModel.UiState.Loaded.Success.PopulatedState(photos = photoResult.data), viewModel.uiState.value)
        }

    @Test
    fun `when loads ViewModel and receive empty Success Photo Result - then ui state is EmptyState`() =
        runTest {
            // Arrange
            val photoResult = PhotoResult.Success(
                data = emptyList<PhotoMetadata>()
            )

            // Act
            photoRepository.sendPhotoResult(photoResult)

            // Assert
            assertEquals(HomeViewModel.UiState.Loaded.Success.EmptyState, viewModel.uiState.value)
        }

    @Test
    fun `when loads ViewModel and receive Error Photo Result - then ui state is Error`() =
        runTest {
            // Arrange
            val photoResult = PhotoResult.Error("Something went wrong!")

            // Act
            photoRepository.sendPhotoResult(photoResult)

            // Assert
            assertEquals(HomeViewModel.UiState.Loaded.Error("Something went wrong!"), viewModel.uiState.value)
        }
}