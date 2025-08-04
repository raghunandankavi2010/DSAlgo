package programs.leetcode

fun main() {
    val input = intArrayOf(1, 2, 1, 3, 5, 6, 4)

    val output = findPeakElement(input)
    println(output)
}

private fun findPeakElement(nums: IntArray): Int {

    var start = 0
    var end = nums.size - 1

    while (end > start) {
        val mid = start + (end - start) / 2
        if (nums[mid] < nums[mid + 1]) {
            start = mid + 1
        } else {
            end = mid
        }
    }

    return end
}