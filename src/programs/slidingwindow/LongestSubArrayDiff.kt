package programs.slidingwindow

import java.util.*
import kotlin.math.max


/**
 * 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 * Medium
 * Topics
 * Companies
 * Hint
 * Given an array of integers nums and an integer limit, return the size of the longest non-empty subarray such that the absolute difference between any two elements of this subarray is less than or equal to limit.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [8,2,4,7], limit = 4
 * Output: 2
 * Explanation: All subarrays are:
 * [8] with maximum absolute diff |8-8| = 0 <= 4.
 * [8,2] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4] with maximum absolute diff |8-2| = 6 > 4.
 * [8,2,4,7] with maximum absolute diff |8-2| = 6 > 4.
 * [2] with maximum absolute diff |2-2| = 0 <= 4.
 * [2,4] with maximum absolute diff |2-4| = 2 <= 4.
 * [2,4,7] with maximum absolute diff |2-7| = 5 > 4.
 * [4] with maximum absolute diff |4-4| = 0 <= 4.
 * [4,7] with maximum absolute diff |4-7| = 3 <= 4.
 * [7] with maximum absolute diff |7-7| = 0 <= 4.
 * Therefore, the size of the longest subarray is 2.
 * Example 2:
 *
 * Input: nums = [10,1,2,4,7,2], limit = 5
 * Output: 4
 * Explanation: The subarray [2,4,7,2] is the longest since the maximum absolute diff is |2-7| = 5 <= 5.
 * Example 3:
 *
 * Input: nums = [4,2,2,2,4,4,2,2], limit = 0
 * Output: 3
 *
 */

fun main() {
    val nums = intArrayOf(8,2,4,7)
    val limit = 4
    val decQ: Deque<Int> = LinkedList() // 8,7,4,2
    val incQ: Deque<Int> = LinkedList()
    var ans = 0
    var left = 0

    for (right in nums.indices) {
        val num: Int = nums[right]

        while (decQ.isNotEmpty() && num > decQ.peekLast()) {
            decQ.pollLast()
        }

        while (incQ.isNotEmpty() && num < incQ.peekLast()) {
            incQ.pollLast()
        }
        decQ.addLast(num)
        incQ.addLast(num)

        while (decQ.peekFirst() - incQ.peekFirst() > limit) {
            if (decQ.peekFirst() == nums.get(left)) {
                decQ.pollFirst()
            }
            if (incQ.peekFirst() == nums.get(left)) {
                incQ.pollFirst()
            }
            ++left
        }

        ans = max(ans.toDouble(), (right - left + 1).toDouble()).toInt()
    }

    println(ans)
}

