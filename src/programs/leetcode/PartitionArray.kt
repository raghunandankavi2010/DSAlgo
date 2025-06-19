package programs.leetcode

fun main() {
    val nums = intArrayOf(3, 6, 1, 2, 5)
    val k = 2
    val output = partitionArray(nums,k)
    println(output)
}
//1,2,3,5,6


private fun partitionArray(nums: IntArray, k: Int): Int {
    nums.sort()
    var count = 0
    var i = 0

    while (i < nums.size) {
        val start = nums[i]
        while (i < nums.size && nums[i] - start <= k) {
            i++
        }
        count++
    }

    return count
}