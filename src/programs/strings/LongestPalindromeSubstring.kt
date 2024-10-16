package programs.strings


/**
 * Longest palindrome substring in o(n2)
 */
object LongestPalindromeSubstring {

    private fun longestPalindrome(str: String): String {
        var maxLength = 1
        var start = 0
        val len = str.length

        if (len <= 1) {
            return str
        }

        for (i in 1..len) {
            var low = i - 1
            var high = i
            while (low >= 0 && high < len && str[low] == str[high]) {
                if (high - low + 1 > maxLength) {
                    start = low
                    maxLength = high - low + 1
                }
                low--
                high++
            }

            low = i - 1
            high = i + 1
            while (low >= 0 && high < len && str[low] == str[high]) {
                if (high - low + 1 > maxLength) {
                    start = low
                    maxLength = high - low + 1
                }
                low--
                high++
            }
        }
        return str.substring(start, start + maxLength)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val str = "forgeeksskeegfor"
        println("Brute force approach")
        val result = findPalindrome(str)
        println(result)
        println("Better approach")
        println(longestPalindrome(str))
        println("Dynamic Programming approach")
        findPalindromeDP(str)

    }

    private fun findPalindrome(str: String): String {
        if (isPalindrome(str)) {
            return str
        } else {
            for (len in str.length downTo 1) {
                var i = 0
                while (i + len <= str.length) {
                    if (isPalindrome(str.substring(i, i + len))) {
                        return str.substring(i, i + len)
                    }
                    i++
                }
            }
        }
        return ""
    }

    private fun isPalindrome(str: String): Boolean {
        var low = 0
        var high = str.length - 1
        while (low <= high && str[low] == str[high]) {
            low++
            high--
        }
        return low >= high
    }

    private fun findPalindromeDP(str: String) {
        val n = str.length
        val dp = Array(n) { BooleanArray(n) }

        var maxLength = 1
        // fill table when string length is 1
        for (i in 0 until n) {
            dp[i][i] = true
        }

        // fill table fro string length 2
        var start = 0
        for (i in 0 until n - 1) {
            if (str[i] == str[i + 1]) {
               dp[i][i+1] = true
                start = i
                maxLength = 2
            }
        }

        for(k in 3.. n) {
            for(i in 0 until n-k+1) {
                val j = i + k - 1
                if (dp[i + 1][j - 1] && str[i] == str[j]) {
                    dp[i][j] = true
                    if (k > maxLength) {
                        start = i
                        maxLength = k
                    }
                }
            }
        }

        println("${str.substring(start,start + maxLength)} and length is $maxLength")

    }
}