package programs.leetcode


/**
 * Find all valid combinations of k numbers that sum up to n such that the following conditions are true:
 *
 * Only numbers 1 through 9 are used.
 * Each number is used at most once.
 * Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Explanation:
 * 1 + 2 + 4 = 7
 * There are no other valid combinations.
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6],[1,3,5],[2,3,4]]
 * Explanation:
 * 1 + 2 + 6 = 9
 * 1 + 3 + 5 = 9
 * 2 + 3 + 4 = 9
 * There are no other valid combinations.
 * Example 3:
 *
 * Input: k = 4, n = 1
 * Output: []
 * Explanation: There are no valid combinations.
 * Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 *
 *
 * Constraints:
 *
 * 2 <= k <= 9
 * 1 <= n <= 60
 */
fun main() {
    val k = 3
    val n = 15
    println(combinationSum3(k, n))
}

/**
 * Time Complexity, I have 9 choices and k combinations
 * O(9 chooses k)
 */
fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val currentComb = mutableListOf<Int>()

    fun backtrack(start: Int, remaining: Int, size: Int) {

        if (remaining == 0 && size == k) {
            result.add(ArrayList(currentComb))
        } else {
            for (i in start..9) {
                currentComb.add(i)
                backtrack(i + 1, remaining - i, size + 1)
                currentComb.removeAt(currentComb.size - 1)
            }
        }
    }

    backtrack(1, n, 0)
    return result
}
//[[1,5,9],[1,6,8],[2,4,9],[2,5,8],[2,6,7],[3,4,8],[3,5,7],[4,5,6]]