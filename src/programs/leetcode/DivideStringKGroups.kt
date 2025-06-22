package programs.leetcode

class Solution {

    fun divideString(s: String, k: Int, fill: Char): Array<String> {
        val result = mutableListOf<String>()
        var i = 0
        while (i < s.length) {
            val end = (i + k).coerceAtMost(s.length)
            val chunk = s.substring(i, end).padEnd(k, fill)
            result.add(chunk)
            i += k
        }
        return result.toTypedArray()
    }
}

fun main() {
    val s = "abcdefghi"
    val k = 3
    val fill = 'x'

    val solution = Solution()
    solution.divideString(s, k, fill).forEach {
        print(it)
    }
}