package programs.backtracking

import java.util.Arrays
import kotlin.math.max

/**
 *
 * You are given an array of events where events[i] = [startDayi, endDayi, valuei]. The ith event starts at startDayi and ends at endDayi, and if you attend this event, you will receive a value of valuei. You are also given an integer k which represents the maximum number of events you can attend.
 *
 * You can only attend one event at a time. If you choose to attend an event, you must attend the entire event. Note that the end day is inclusive: that is, you cannot attend two events where one of them starts and the other ends on the same day.
 *
 * Return the maximum sum of values that you can receive by attending events.
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: events = [[1,2,4],[3,4,3],[2,3,1]], k = 2
 * Output: 7
 * Explanation: Choose the green events, 0 and 1 (0-indexed) for a total value of 4 + 3 = 7.
 */
fun main() {
    val events = arrayOf(
        intArrayOf(1, 2, 4),
        intArrayOf(3, 4, 3),
        intArrayOf(2, 3, 1),
    )
    val k = 2
    val result = maxValue(events, k)
    println(result)
}


fun maxValue(events: Array<IntArray>, k: Int): Int {
    Arrays.sort(events) { a, b -> a[0] - b[0] }
    return find(events, 0, k)
}

private fun find(ev: Array<IntArray>, curr: Int, k: Int): Int {
    if (k <= 0 || curr >= ev.size) return 0

    val mValue = ev[curr][2]

    // find the next index
    var j = curr + 1
    while (j < ev.size) {
        if (ev[j][0] > ev[curr][1]) {
            break
        }
        j++
    }
    // take current index
    val take = mValue + find(ev, j, k - 1)
    // skip current index
    val skip = find(ev, k, curr + 1)
    return max(skip, take)
}

