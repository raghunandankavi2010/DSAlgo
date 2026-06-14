package programs.leetcode

fun main() {
    val nums1 = intArrayOf(1, 2)
    val nums2 = intArrayOf(3, 4)

    val median = findMedianSortedArrays(nums1, nums2)
    print("Median of two sorted arrays us $median")
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Any {
    if (nums1.size > nums2.size) {
        return findMedianSortedArrays(nums2, nums1)
    }

    val m: Int = nums1.size
    val n: Int = nums2.size
    var low = 0
    var high = m

    while (low <= high) {

        val partition1 = (low + high) / 2
        val partition2 = (m + n + 1) / 2 - partition1

        val maxLeft1 = if (partition1 == 0) Int.MIN_VALUE else nums1[partition1 - 1]
        val minRight1 = if (partition1 == m) Int.MAX_VALUE else nums1[partition1]

        val maxLeft2 = if (partition2 == 0) Int.MIN_VALUE else nums2[partition2 - 1]
        val minRight2 = if (partition2 == n) Int.MAX_VALUE else nums2[partition2]
        if (maxLeft1 <= maxLeft2 && minRight1 <= minRight2) {
            return if ((m + n) % 2 != 0) {
                maxLeft1.coerceAtLeast(maxLeft2)
            } else {
                (maxLeft1.coerceAtLeast(maxLeft2) + minRight1.coerceAtMost(minRight2)) / 2.0
            }
        } else if (maxLeft1 > minRight2) {
            high = partition1 - 1
        } else {
            low = partition1 + 1
        }
    }
    throw IllegalArgumentException("Input arrays are not sorted.")
}

