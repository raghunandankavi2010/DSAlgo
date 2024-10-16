package programs.arrays

import kotlin.math.max
import kotlin.math.min

/**
 * Given an integer array nums, find a
subarray
that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.

 */

fun main() {

    val input = arrayOf(2,3,-2,-5,6,-1,4)
    val output = maxSubArrayProduct2(input)
    println(output)

}

fun maxSubArrayProduct(nums: Array<Int>): Int {
    var ans = 0
    var l = 1
    var r = 1
    val n = nums.size

    for(i in 0 until n) {
        l = if (l == 0) 1 else l
        r = if (r == 0) 1 else r

        l *= nums[i]
        r *= nums[n -1 -i]

        ans = max(ans,max(l,r))

    }
    return ans
}

fun maxSubArrayProduct2(nums: Array<Int>): Int {
    var ans = nums[0]

    var currMax = nums[0]
    var currMin = nums[0]
    val n = nums.size

    for(i in 1 until n) {
        if(nums[i] == 0) {
            currMax = 1
            currMin = 1
        }
        val tmp = currMax * nums[i]
        currMax = max(nums[i],max(currMax * nums[i], currMin * nums[i]))
        currMin = min(nums[i],min(tmp, currMin * nums[i]))

        if (currMax > ans) {
            ans = currMax
        }
    }
    return ans
}

