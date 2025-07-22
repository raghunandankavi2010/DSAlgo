package programs.algoexpert

fun main() {
    val s1 = "abc"
    val s2 = "yabd"
    val distance = levenshteinDistance(s1, s2)
    println(distance)
}

private fun levenshteinDistance(s1: String, s2: String): Int {

    val m = s1.length
    val n = s2.length
    val dp = Array(m + 1) { IntArray(n + 1) }

    for(j in 0.. n) {
        dp[0][j] = j
    }

    for(i in 0.. m) {
        dp[i][0] = i
    }

    for(i in 1 .. m) {
        for (j in 1 .. n) {
            val cost = if(s1[i-1] == s2[j-1]) 0 else 1
            val deletionCost = dp[i-1] [j] + 1
            val insertionCost = dp[i] [j-1] + 1
            val substitutionCost = dp[i - 1][j - 1] + cost
            dp[i] [j] = minOf(deletionCost,insertionCost, substitutionCost)
        }
    }
    return dp[m][n]
}
