package xyz.leomurca.flickrfinder.util

import junit.framework.TestCase.assertEquals
import org.junit.Test

class SystemDateFormatterTest {

    private val systemDateFormatter = SystemDateFormatter()

    @Test
    fun `when DatePattern is FULL_MONTH_DAY_COMMA_YEAR then returns formatted date string`() {
        // Arrange
        val dateString = "2024-06-11T15:41:36-08:00"
        val datePattern = DatePattern.FULL_MONTH_DAY_COMMA_YEAR

        // Act
        val result = systemDateFormatter.dateStringToPattern(dateString, datePattern)

        // Assert
        assertEquals("June 11, 2024", result)
    }

    @Test
    fun `when date string is blank then returns -`() {
        // Arrange
        val dateString = ""
        val datePattern = DatePattern.FULL_MONTH_DAY_COMMA_YEAR

        // Act
        val result = systemDateFormatter.dateStringToPattern(dateString, datePattern)

        // Assert
        assertEquals("-", result)
    }
}