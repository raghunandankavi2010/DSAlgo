package programs.leetcode

private fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
    fun getPrefixes(num: Int): Set<String> {
        val prefixes = mutableSetOf<String>()
        val numStr = num.toString()
        for (i in 1..numStr.length) {
            prefixes.add(numStr.substring(0, i))
        }
        return prefixes
    }

    // Step 1: Store all prefixes of elements in arr1 in a HashSet
    val prefixSet = mutableSetOf<String>()
    for (num in arr1) {
        prefixSet.addAll(getPrefixes(num))
    }

    // Step 2: Check prefixes of elements in arr2 against the HashSet
    var maxLength = 0
    for (num in arr2) {
        val numStr = num.toString()
        for (i in 1..numStr.length) {
            if (prefixSet.contains(numStr.substring(0, i))) {
                maxLength = maxOf(maxLength, i)
            }
        }
    }

    return maxLength
}

// Example usage:
fun main() {
    val arr1 = intArrayOf(1, 10, 100)
    val arr2 = intArrayOf(1000)
    println(longestCommonPrefix(arr1, arr2))  // Output: 3

    val arr1_2 = intArrayOf(1, 2, 3)
    val arr2_2 = intArrayOf(4, 4, 4)
    println(longestCommonPrefix(arr1_2, arr2_2))  // Output: 0
}
