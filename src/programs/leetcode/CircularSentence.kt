package programs.leetcode

fun main() {
    println(isCircularSentence("leetcode exercises sound delightful")) // Should return true
    println(isCircularSentence("eetcode")) // Should return true
    println(isCircularSentence("leetcode eats soul")) // Should return true
    println(isCircularSentence("Leetcode is cool")) // Should return false
    println(isCircularSentence("happy Leetcode")) // Should return false
    println(isCircularSentence("Leetcode")) // Should return false
    println(isCircularSentence("I like Leetcode")) // Should return false
}

private fun isCircularSentence(sentence: String): Boolean {
    val words = sentence.split(" ")
    for (i in words.indices) {
        val lastChar = words[i].last()
        val firstChar = words[(i + 1) % words.size].first()
        if (lastChar != firstChar) {
            return false
        }
    }
    return true
}