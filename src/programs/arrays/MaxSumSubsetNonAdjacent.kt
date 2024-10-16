package programs.arrays

import kotlin.math.max

/**
 * Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset. It is possible that the maximum sum is , the case when all elements are negative.

Example
[-2,1,3-4,5]

The following subsets with more than  element exist. These exclude the empty subset and single element subsets which are also valid.
 */
fun main() {

    val arr = intArrayOf(-2, -4, -5)
    println(maxSubsetSum(arr))
    println(maxSubsetSum2(arr))
}
// max = 0
// maxAdj  = 0
// maxAdj = max(s[i],maxAdj) = 0,0 = 0
// s[i+2]  = s[2] = arr[i] + maxAdj = -2 + 0 = -2
// max = max[s[i+2],max] = 0
// maxAdj = s[1] = 0
// s[i+2] = s[3] = arr[i] + maxAdj = 1 + 0 =1
// max = 1

private fun maxSubsetSum(arr: IntArray): Int {
    val s = IntArray(arr.size + 2)
    var max = 0
    var maxAdj = 0
    for (i in arr.indices) {
        maxAdj = max(s[i], maxAdj)
        s[i + 2] = maxAdj + arr[i]
        max = max(s[i + 2], max)
    }
    return max
}
/** [-2,1,3-4,5]
* nitially arr[0] = -2
 * arr[1] = 1
 * sum at index 2 can be sum at index - 1 if current element is excluded or
 * sum at index - 2 + arr[2] -> the current element. This is because they are non-adjacent
 * we take the max
*/
private fun maxSubsetSum2(arr: IntArray): Int {
    val maxSum = IntArray(arr.size)
    if(arr.isEmpty()) return 0
    if(arr.size == 1) return arr[0]
    for(i in 2 until arr.size) {
        maxSum[i] = max(maxSum[i-1], maxSum[i-2] + arr[i])
    }
    return maxSum[arr.size-1]
}
