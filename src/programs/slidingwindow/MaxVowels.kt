package programs.slidingwindow


/**
 * Input: s = "abciiidef", k = 3
 * Output: 3
 * Submission Link : https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/submissions/?envType=daily-question&envId=2023-09-02
 */
fun main() {

    val s = "abciiidef"
    val k = 3
    val output = getMaxVowels(s,k)
    println("Max vowels in s $s of susbtring $k is $output")
}

fun getMaxVowels(s: String, k: Int): Int {
    if (s.isEmpty()) return 0
    var count = 0

    // count for 1st k characters
    for(i in 0 until k) {
        if(isVowel(s[i])) {
            count++
        }
    }
    // the max is the count for 1st k chars
    var max = count

    // end index = k - 1 since index is 0 based
    var end = k - 1
    // start is 0
    var start = 0

    while (end < s.length - 1) {
        // sliding window is remove from start and consider end + 1 element
        if (isVowel(s[start]) && count > 0) count-- // consider start and remove the count for start if its a vowel
        if (isVowel(s[end + 1])) count++ // consider the end + 1 and if its a vowel increment count
        // increment the two pointers
        start++
        end++
        // update the count since we want the max count
        max = kotlin.math.max(count,max)

    }

    return max
}

fun isVowel(c: Char): Boolean {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
}
