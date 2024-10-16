package programs.leetcode

fun main() {
    val arr1 = intArrayOf(5655359)
    val arr2 = intArrayOf(56554)
    println(longestCommonPrefix(arr1,arr2))
}

private fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
    val prefixSet = HashSet<String>()

    //arr1 = [1,10,100], arr2 = [1000]
    for (num in arr1) {
        val str = num.toString()
        for (i in 1..str.length) {
            prefixSet.add(str.substring(0, i))
        }
    }
    var maxLength = 0
    for (num in arr2) {
        val str = num.toString()
        for (i in 1..str.length) {
            val prefix = str.substring(0, i)
            if (prefix in prefixSet && i > maxLength) {
                maxLength = i
            }
        }
    }


    return maxLength

}