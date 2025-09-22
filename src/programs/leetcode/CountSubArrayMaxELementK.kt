package programs.leetcode

private fun countSubarrays(nums: IntArray, k: Int): Long {

    if (nums.isEmpty()) {
        return 0L
    }
    val maxElement = nums.maxOrNull() ?: return 0L

    var count = 0
    var left = 0
    var ans: Long = 0

    for (right in nums.indices) {
        if (nums[right] == maxElement) {
            count++
        }

        while (count >= k) {
            ans += (nums.size - right)
            if (nums[left] == maxElement) {
                count--
            }
            left++
        }
    }

    return ans
}

fun main() {
    val input = intArrayOf(1,3,2,3,3)
    val k = 2
    println(countSubarrays(input,k))
}