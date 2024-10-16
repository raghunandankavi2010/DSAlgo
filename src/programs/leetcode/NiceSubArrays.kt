package programs.leetcode

/**
 * Given an array of integers nums and an integer k. A continuous subarray is called nice if there are k odd numbers on it.
 *
 * Return the number of nice sub-arrays.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,1,1], k = 3
 * Output: 2
 * Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].
 * Example 2:
 *
 * Input: nums = [2,4,6], k = 1
 * Output: 0
 * Explanation: There are no odd numbers in the array.
 * Example 3:
 *
 * Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * Output: 16
 *
 */

fun main() {
    val arr = intArrayOf(2, 2, 2, 1, 2, 2, 1, 2, 2, 2)
    // Loop through the array and modify elements
//    for (i in arr.indices) {
//        arr[i] = arr[i] % 2
//    }
    val k = 2

    val result1 = numSubArray(arr, k)
    val result2 = numSubArray(arr, k - 1)
    println(result1 - result2)
}

private fun numSubArray(arr: IntArray, k: Int): Int {
    if (k < 0) return 0
    var l = 0
    var r = 0
    var sum = 0
    var count = 0

    while (r < arr.size) {
        sum += arr[r] % 2

        while (sum > k) {
            sum -= arr[l] % 2
            l += 1
        }

        count += (r - l + 1)
        r++
    }
    return count
}