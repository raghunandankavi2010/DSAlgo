package programs.leetcode

fun main() {
    val n = 5
    val dp = Array(n) { 0 }
    val recursive = climbStairsRecursive(n, dp)
    println(recursive)
    val output = climbStairsIterative(n)
    println(output)
}


private fun climbStairsIterative(n: Int): Int {
    val dp = Array(n+1) { 0 }

    dp[1] = 1
    dp[2] = 2

    for(i in 3.. n) {
        dp[i] =  dp[i-1] + dp [i-2]
    }

    return dp[n]
}

private fun climbStairsRecursive(n: Int, dp: Array<Int>, steps: Int = 0): Int {
    if (steps == n) return 1

    if(steps > n) return 0

    val currentStep = steps + 1

    if (dp[steps] > 0) {
        return dp[steps]
    }
    val ways =  climbStairsRecursive(n, dp,currentStep) + climbStairsRecursive(n, dp ,currentStep + 1)

    dp[steps] = ways
    return ways
}