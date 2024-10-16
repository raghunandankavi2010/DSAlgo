package programs.test

import java.util.*


fun main() {
    // Calucalte time difference
    // in milliseconds
    // Calucalte time difference
    // in milliseconds
    val difference_In_Time: Long = 1617215400000 - 1615289948000

    // Calucalte time difference in
    // seconds, minutes, hours, years,
    // and days

    // Calucalte time difference in
    // seconds, minutes, hours, years,
    // and days
    val difference_In_Seconds = ((difference_In_Time
            / 1000)
            % 60)

    val difference_In_Minutes = ((difference_In_Time
            / (1000 * 60))
            % 60)

    val difference_In_Hours = ((difference_In_Time
            / (1000 * 60 * 60))
            % 24)

    val difference_In_Years = (difference_In_Time
            / (1000L * 60 * 60 * 24 * 365))

    val difference_In_Days = difference_In_Time / (1000  * 60 * 60 * 24)


    val t1 = Date(1617215400000)
    val t2 = Date(1630434540000 )
    val startDate = getEnd(t1)
    val endDate = getEnd(t2)

    var days = startDate?.time?.let { endDate?.time?.let { it1 -> getDayCount(it, it1) } }


  println(days)
}

fun getEnd(date: Date?): Date? {
    if (date == null) {
        return null
    }
    val c = Calendar.getInstance()
    c.time = date
    c[Calendar.HOUR_OF_DAY] = 23
    c[Calendar.MINUTE] = 59
    c[Calendar.SECOND] = 59
    c[Calendar.MILLISECOND] = 999
    return c.time
}

fun getDayCount(start: Long, end: Long): Long {
    var diff: Long = -1

        //time is always 00:00:00, so rounding should help to ignore the missing hour when going from winter to summer time, as well as the extra hour in the other direction
    diff = ((start - end)) / (1000  * 60 * 60 * 24)//86400000.toLong()

    return diff
}