package xyz.leomurca.flickrfinder.util

interface DateFormatter {
    fun dateStringToPattern(dateString: String, pattern: DatePattern): String
}
enum class DatePattern(val value: String) {
    FULL_MONTH_DAY_COMMA_YEAR("MMMM d, yyyy")
}
