package programs.leetcode

fun main() {
    val n = 5
    val dp = Array(n) { 0 }
    val output = climbStairs(n, dp)
    print(output)
}

fun climbStairs(n: Int, dp: Array<Int>, steps: Int = 0): Int {
    if (steps == n) return 1

    if(steps > n) return 0

    val currentStep = steps + 1

    if (dp[steps] > 0) {
        return dp[steps]
    }
    val ways =  climbStairs(n, dp,currentStep) + climbStairs(n, dp ,currentStep + 1)

    dp[steps] = ways
    return ways
}