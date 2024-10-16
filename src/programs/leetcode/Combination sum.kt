package programs.leetcode

import java.util.*

/**
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.
 *
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
 * frequency
 *  of at least one of the chosen numbers is different.
 *
 * The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 *
 *
 *
 * Example 1:
 *
 * Input: candidates = [2,3,6,7], target = 7
 * Output: [[2,2,3],[7]]
 * Explanation:
 * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
 * 7 is a candidate, and 7 = 7.
 * These are the only two combinations.
 * Example 2:
 *
 * Input: candidates = [2,3,5], target = 8
 * Output: [[2,2,2,2],[2,3,3],[3,5]]
 * Example 3:
 *
 * Input: candidates = [2], target = 1
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 30
 * 2 <= candidates[i] <= 40
 * All elements of candidates are distinct.
 * 1 <= target <= 40
 */
fun main() {
    val arr = arrayOf(10,1,2,7,6,1,5)
    val target = 8
    val intArray = arr.toIntArray()
    val result = combinationSum(intArray, target)
    result.forEach {
        println(it)

    }
}

val list: MutableList<MutableList<Int>> = mutableListOf()

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    val temp: MutableList<Int> = mutableListOf()
    Arrays.sort(candidates)
    combinationSumHelper2(list, temp, candidates, 0, target)
    return list
}

fun combinationSumHelper(
    list: MutableList<MutableList<Int>>,
    temp: MutableList<Int>,
    nums: IntArray,
    i: Int,
    sum: Int
) {
    if (sum < 0) return
    if (sum == 0) {
        val mList: MutableList<Int> = mutableListOf()
        mList.addAll(temp)
        list.add(mList)
    }
    for (index in i until nums.size) {
        temp.add(nums[index])
        combinationSumHelper(list, temp, nums, index, sum - nums[index])
        temp.removeAt(temp.size - 1)
    }
}

fun combinationSumHelper2(
    list: MutableList<MutableList<Int>>,
    temp: MutableList<Int>,
    nums: IntArray,
    i: Int,
    sum: Int
) {
    if (sum < 0) return
    if (sum == 0) {
        val mList: MutableList<Int> = mutableListOf()
        mList.addAll(temp)
        list.add(mList)
    }
    for (index in i until nums.size) {
        if (index > i && nums[index] == nums[index - 1]) continue // skip duplicates
        temp.add(nums[index])
        combinationSumHelper2(list, temp, nums, index + 1, sum - nums[index])
        temp.removeAt(temp.size - 1)
    }
}
