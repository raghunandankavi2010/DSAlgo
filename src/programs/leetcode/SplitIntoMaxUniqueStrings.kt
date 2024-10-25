package programs.leetcode

fun maxUniqueSplit(s: String): Int {
    fun backtrack(start: Int, unique: MutableSet<String>): Int {
        if (start == s.length) {
            return unique.size
        }

        var maxSplit = 0
        for (end in start + 1..s.length) {
            val substring = s.substring(start, end)
            if (substring !in unique) {
                unique.add(substring)
                maxSplit = maxOf(maxSplit, backtrack(end, unique))
                unique.remove(substring)
            }
        }
        return maxSplit
    }

    return backtrack(0, mutableSetOf())
}

// Example usage:
fun main() {
    println(maxUniqueSplit("ababccc"))  // Output: 5
    println(maxUniqueSplit("aba"))      // Output: 2
    println(maxUniqueSplit("aa"))       // Output: 1
}
