package programs.algoexpert

import kotlin.math.max

fun main() {
    val input = arrayOf(75,105,-1).toList()
    val output = maxSubsetSumNoAdjacent(input)
    println(output)

}

private fun maxSubsetSumNoAdjacent(array: List<Int>): Int {
    // Write your code here.
    if(array.isEmpty()) return 0
    if(array.size == 1) return array[0]

    var maxSum: Int

    val dp = IntArray(array.size) {0}

    dp[0] = array[0]
    maxSum = dp[0]
    dp[1] = max(array[1], dp[0])

    maxSum = max(maxSum,dp[1])

    for(i in 2 until array.size) {
        dp[i] = max(dp[i-1], array[i]+dp[i-2])
        maxSum = max(maxSum,dp[i])
    }


    return maxSum
}