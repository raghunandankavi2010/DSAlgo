package programs.arrays

import kotlin.math.max
import kotlin.math.min

/**
 * 55. Jump Game
 * Solved
 * Medium
 * Topics
 * Companies
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 105
 */

fun main() {
    val arr = intArrayOf(
        2, 3, 1, 1, 4
    )
    println(jumGame2Greedy(arr))

}

private fun jumGame2Greedy(nums: IntArray): Int {
    var l = 0
    var r = 0
    var far = 0
    var res = 0
    while (r < nums.size - 1) {
        for (i in l.. r) {
            far = max (far, i + nums[i])
        }
        l = r + 1
        r = far
        res++

    }
    return res
}

private fun findJumpsRecursive(nums: IntArray, i: Int, jumps: Int): Int {
    if (i >= nums.size - 1) return jumps
    var mini = Integer.MAX_VALUE
    for (j in 1..nums[i]) {
        mini = min(mini, findJumpsRecursive(nums, i + j, jumps + 1))
    }
    return mini
}

private fun jumpGame2(nums: IntArray): Int {

    var far = 0
    var end = 0
    var jumps = 0

    for (i in 0 until nums.size - 1) {

        far = max(far, i + nums[i])
        if (end == i) {
            jumps++
            end = far
        }

    }

    return jumps
}


fun canJump(nums: IntArray): Boolean {
    var reachable = 0
    var jumps = 0
    for (i in nums.indices) {
        if (i > reachable) return false
        reachable = max(reachable, i + nums[i])
        jumps++
    }
    print(jumps)
    return true
}

// Goal is at last index initally.
// if we can reach the last index by using previous index then we can reach last index
// so shift the goal post by 1 when you can reach the end each time
fun canJump2(nums: IntArray): Boolean {
    var goalPost = nums[nums.size - 1]
    for (i in nums.size - 1 downTo 0) {
        if (i + nums[i] >= goalPost)
            goalPost = i
    }
    return goalPost == 0
}