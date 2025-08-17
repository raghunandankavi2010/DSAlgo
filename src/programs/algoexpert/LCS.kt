package programs.algoexpert

fun main() {

    val str1 = "ZXVVYZW"
    val str2 = "XKYKZPW"
    val result = lcs(str1, str2)
    println(result)
}

private fun lcs(s1: String, s2: String): List<Char> {

    val dp = Array(s1.length + 1) { Array(s2.length + 1) { "" } }

    for (i in 1..s1.length) {
        for (j in 1..s2.length) {
            if (s1[i - 1] == s2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + s1[i - 1]
            } else {
                val topString = dp[i - 1][j]
                val leftString = dp[i][j - 1]
                dp[i][j] = if (topString.length > leftString.length) topString else leftString
            }
        }
    }

    return dp[s1.length][s2.length].toCharArray().toList()
}