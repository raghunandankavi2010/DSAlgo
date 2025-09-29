package programs.leetcode

fun partition(s: String): List<List<String>> {

    val currentPartition  = mutableListOf<String>()
    val result = mutableListOf<List<String>>()
    val n = s.length

    fun isPalindrome(sub: String): Boolean {
        return sub == sub.reversed()
    }
    fun backtrack(startIndex: Int) {
        if(startIndex == n) {
            result.add(ArrayList(currentPartition))
            return
        }
        for( i in startIndex until n) {
            val currentSubString = s.subSequence(startIndex, i+1)
            if(isPalindrome(currentSubString.toString())) {
                currentPartition.add(currentSubString.toString())
                backtrack(i+1)
                currentPartition.removeAt(currentPartition.size - 1)
            }
        }
    }

    backtrack(0)

    return result

}


fun main() {
    val input = "aab"
    println(partition(input))
}