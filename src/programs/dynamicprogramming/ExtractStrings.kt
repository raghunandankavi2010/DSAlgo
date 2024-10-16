package programs.dynamicprogramming

import java.util.HashSet
import kotlin.math.min

/***
 * You are given a 0-indexed string s and a dictionary of words dictionary. You have to break s into one or more non-overlapping substrings such that each substring is present in dictionary. There may be some extra characters in s which are not present in any of the substrings.
 *
 * Return the minimum number of extra characters left over if you break up s optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "leetscode", dictionary = ["leet","code","leetcode"]
 * Output: 1
 * Explanation: We can break s in two substrings: "leet" from index 0 to 3 and "code" from index 5 to 8. There is only 1 unused character (at index 4), so we return 1.
 *
 * Example 2:
 *
 * Input: s = "sayhelloworld", dictionary = ["hello","world"]
 * Output: 3
 * Explanation: We can break s in two substrings: "hello" from index 3 to 7 and "world" from index 8 to 12. The characters at indices 0, 1, 2 are not used in any substring and thus are considered as extra characters. Hence, we return 3.
 */
fun main() {
    val input = "sayhelloworld"
    val dictionary = arrayOf("hello","world")
    val count  = minExtraChar(input, dictionary)
    println(count)
}

fun minExtraChar(s: String, dictionary: Array<String>): Int {
    val dp = IntArray(s.length) { Integer.MAX_VALUE }
    val set = dictionary.toHashSet()
    return dfs(s,0,dp,set)


}
// Walkthrough
// leetscode
// index = 0, l -> skip
// consider eetscode this is not in dict
// now index is 8
// for index 8  ans = 1

fun dfs(input: String, index: Int, dp: IntArray, dict: HashSet<String>): Int {
    // base condition for recursive function
    if(input.length == index) return 0

    // memoization if we have already visited the same index
    if(dp[index] != Int.MAX_VALUE){
        return dp[index]
    }

    // answer or count while skipping the current char
    var ans = 1 + dfs(input,index+1,dp,dict)

    for(i in index until input.length) {
        // check the suffix in dict
        val substring = input.substring(index,i+1)
        if(dict.contains(substring)) {
            // calculate the skips
            ans = min(ans,dfs(input,i+1,dp,dict))
        }
    }
    // update answer at index
    dp [index] = ans
    return ans

}