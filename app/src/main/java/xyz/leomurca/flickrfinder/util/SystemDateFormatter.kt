package xyz.leomurca.flickrfinder.util

import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class SystemDateFormatter : DateFormatter {
    override fun dateStringToPattern(dateString: String, pattern: DatePattern): String {
        if (dateString.isBlank()) return "-"
        val zonedDateTime = ZonedDateTime.parse(dateString, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        return DateTimeFormatter.ofPattern(pattern.value, Locale.getDefault()).format(zonedDateTime)
    }
}