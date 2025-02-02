package programs.leetcode


fun main() {
    val array = intArrayOf(1,2,3,4)
    print(check(array))
}

fun check(nums: IntArray): Boolean {
    if (nums.size <= 2) return true

    var previous = nums[0]
    val start = nums[0]
    var pivotIndex = -1

    for (i in 1 until nums.size) {
        if (previous > nums[i]) {
            if (pivotIndex == -1) pivotIndex = i else return false
            if (nums[i] > start) return false
        } else {
            if (pivotIndex != -1 && nums[i] > start) return false
        }
        print(pivotIndex)
        println()
        previous = nums[i]
    }

    return true
}