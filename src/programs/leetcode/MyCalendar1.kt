package programs.leetcode

val intervals = mutableListOf<Intervals>()

class MyCalendar {
    fun book(start: Int, end: Int): Boolean {
        for (interval in intervals) {
            if (start < interval.end && end > interval.start) {
                // Overlapping interval, can't book this time slot
                return false
            }
        }
        intervals.add(Intervals(start, end))
        intervals.sortBy { it.start }
        return true
    }
}

data class Intervals(val start: Int, val end: Int)

fun main() {
    val myCalendar = MyCalendar()
    println(myCalendar.book(47, 50)) // true
    println(myCalendar.book(33, 41)) // true
    println(myCalendar.book(39, 45)) // false
    println(myCalendar.book(33, 42)) // false
    println(myCalendar.book(25, 32)) // true
    println(myCalendar.book(26, 35)) // false
    println(myCalendar.book(19, 25)) // true
    println(myCalendar.book(3, 8)) // true
    println(myCalendar.book(8, 13)) // true
    println(myCalendar.book(18, 27)) // false
}