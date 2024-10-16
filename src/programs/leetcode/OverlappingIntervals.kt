package programs.leetcode

fun main() {
    val intervals = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 6),
        intArrayOf(8, 10),
        intArrayOf(15, 18)
    )
    val list = merge(intervals)
    list.forEach {
        println("${it[0]} ${it[1]}")
    }
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    intervals.sortBy { it[0] }
    val list = mutableListOf<IntArray>()
    list.add(intervals[0])
    for(i in 1 until intervals.size) {
        val last: IntArray = list[list.size - 1]
        val curr: IntArray = intervals[i]
        if (curr[0] <= last[1]) {
            last[1] = last[1].coerceAtLeast(curr[1])
        } else {
            list.add(curr)
        }
    }
    return list.toTypedArray()
}