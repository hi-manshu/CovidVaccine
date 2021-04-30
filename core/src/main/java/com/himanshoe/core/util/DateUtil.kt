package com.himanshoe.core.util

import java.text.SimpleDateFormat
import java.util.*

object DateUtil {
    fun Date.toStringFormat(
        format: String = "dd-MM-yyyy",
        locale: Locale = Locale.ENGLISH
    ): String {
        val formatter = SimpleDateFormat(format, locale)
        return formatter.format(this)
    }

    fun currentDateInString(): String {
        return getCurrentDateTime().toStringFormat()
    }

    fun getCurrentDateTime(): Date {
        return Calendar.getInstance().time
    }
}