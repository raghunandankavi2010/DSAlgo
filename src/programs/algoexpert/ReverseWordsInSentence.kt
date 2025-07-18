package programs.algoexpert

fun main() {
    val s1 = "the sky is blue"
    println("Original:  '$s1'")
    println("Reversed:  '${reverseWords(s1)}'") // Will now be correct: "blue is sky the"
}

private fun reverseWords(s: String): String {
    val charArr = s.toCharArray()
    reverse(charArr, 0, charArr.size - 1)

    var wordStart = 0
    for (i in 0..charArr.size) {
        if (i == charArr.size || charArr[i] == ' ') {
            val wordEnd = i - 1
            reverse(charArr, wordStart, wordEnd)
            wordStart = i + 1
        }
    }
    return String(charArr)
}

private fun reverse(charArr: CharArray, i: Int, j: Int) {
    var start = i
    var end = j

    while (start < end) {
        val temp = charArr[start]
        charArr[start] = charArr[end]
        charArr[end] = temp
        start++
        end--
    }
}
