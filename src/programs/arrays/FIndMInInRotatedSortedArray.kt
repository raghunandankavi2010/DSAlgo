package programs.arrays

private fun findMinElem(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    // Optimization: If the array is not rotated, return the first element
    if (nums[left] <= nums[right]) {
        return nums[left]
    }

    while (left < right) {
        val mid = left + (right - left) / 2

        if (nums[mid] > nums[right]) {
            // The minimum must be in the right part
            left = mid + 1
        } else {
            // The minimum is mid or in the left part
            right = mid
        }
    }

    // When left == right, we've found the smallest element
    return nums[left]
}

fun main() {
    // Test Case 1: Rotated array
    val nums1 = intArrayOf(3,4,5,1,2)
    println("Array: ${nums1.joinToString(", ")}")
    println("Minimum: ${findMinElem(nums1)}") // Output: 0

    println("---")

    // Test Case 2: Array rotated n times (fully sorted)
    val nums2 = intArrayOf(11, 13, 15, 17)
    println("Array: ${nums2.joinToString(", ")}")
    println("Minimum: ${findMinElem(nums2)}") // Output: 11

    println("---")

    // Test Case 3: Small array
    val nums3 = intArrayOf(2, 1)
    println("Array: ${nums3.joinToString(", ")}")
    println("Minimum: ${findMin(nums3)}") // Output: 1
}