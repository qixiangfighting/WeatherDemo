package com.test.foundationlib.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 *  Format the date or time
 *
 */
object DateUtils {

    /**
     *  12-01
     */

    var FORMAT_MONTH_DAY = "MM-dd"
    /**
     * 2019-12-01
     */
    var FORMAT_SHORT = "yyyy-MM-dd"

    /**
     *  2019-12-01 21:15:06
     */
    var datePattern = "yyyy-MM-dd HH:mm:ss"

    var FORMAT_SHORT_SPE_ = "HH:mm"

    var TIMEZONE = "Asia/Shanghai"

    fun format(date: Date?, timeZone: String = TIMEZONE, pattern: String = datePattern): String {
        var returnValue = ""
        if (date != null) {
            val df = SimpleDateFormat(pattern, Locale.getDefault())
            df.timeZone = TimeZone.getTimeZone(timeZone)
            returnValue = df.format(date)
        }
        return returnValue
    }


    /**
     *
     * Convert Fahrenheit  to Centigrade
     *
     * C = (F-32)*5/9
     *
     */

    fun convertFtemp2Ctemp(temperature: Double): String {
        return "${((temperature - 32) * 5 / 9).toInt()}"
    }

}
