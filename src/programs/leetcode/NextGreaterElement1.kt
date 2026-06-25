package programs.leetcode

fun main() {

    val nums1 = intArrayOf(4,1,2)
    val nums2 = intArrayOf(1,3,4,2)
    print("Next Greater  Element ${nextGreaterElement(nums1,nums2).contentToString()}")
    println("Expected [-1, 3,-1]")

}

/**
 *   n size of nums1
 *   m  size of nums2
 *   stack size O(m)
 *   res size  O(n)
 *   Time complexity O(m+n)
 */
private fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {

    val stack = ArrayDeque<Int>()
    val res = IntArray(nums1.size) { 0 }

    val map = mutableMapOf<Int, Int>()


    for (i in nums2.size-1 downTo 0) {

        while (stack.isNotEmpty() && stack.last() <= nums2[i]) {
            stack.removeLast()
        }

        if (stack.isNotEmpty()) {
            val stackElement = stack.last()
            map[nums2[i]] = stackElement

        } else {
            map[nums2[i]] = -1
        }

        stack.addLast(nums2[i])

    }

    for (j in 0 until nums1.size) {
        val elem = nums1[j]
        val elemValue = map.get(elem) ?: -1
        res[j] = elemValue
    }
    return res
}
