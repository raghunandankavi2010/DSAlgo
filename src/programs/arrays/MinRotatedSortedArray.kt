package programs.arrays

/**
 * Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums of unique elements, return the minimum element of this array.

You must write an algorithm that runs in O(log n) time.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 */

fun main() {
    val nums = arrayOf(2,3,4,5,1)
    val min = findMin(nums, 0, nums.size - 1)
    if (min == -1) {
        println(nums[0])
    } else {
        println(nums[min])
    }
}

fun findMin(nums: Array<Int>, low: Int, high: Int): Int {


    // base cases
    if (high < low) {
        return -1
    }

    val mid = (low + high) / 2

    if (mid < high && nums[mid] > nums[mid + 1])
        return mid + 1
    if (mid > low && nums[mid] < nums[mid - 1])
        return mid
    if (nums[low] >= nums[mid])
        return findMin(nums, low, mid - 1)
    return findMin(nums, mid + 1, high)

}


