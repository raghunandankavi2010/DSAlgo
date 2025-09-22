package programs.leetcode

/*
You are given an array nums consisting of positive integers.

Return the total frequencies of elements in nums such that those elements all have the maximum frequency.

The frequency of an element is the number of occurrences of that element in the array.



Example 1:

Input: nums = [1,2,2,3,1,4]
Output: 4
Explanation: The elements 1 and 2 have a frequency of 2 which is the maximum frequency in the array.
So the number of elements in the array with maximum frequency is 4.
Example 2:

Input: nums = [1,2,3,4,5]
Output: 5
Explanation: All elements of the array have a frequency of 1 which is the maximum.
So the number of elements in the array with maximum frequency is 5.

 */
private fun maxFrequencyElements(nums: IntArray): Int {

    val map = HashMap<Int, Int>()

    nums.forEach {
        map[it] = map.getOrDefault(it,0)+1
    }
    val highFreq = map.maxBy { it.value }.value
    return  map.entries.filter { it.value == highFreq }.sumOf { it.value }

}

/**
 * O(n) time complexity
 * O(n) space complexity
 */

fun main() {

    val input = intArrayOf(10,12,11,9,6,19,11)
    print(maxFrequencyElements(input))

}