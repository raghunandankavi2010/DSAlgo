package programs.strings


fun numberOfSpecialChars(word: String): Int {
    var count = 0
    val hasLower = BooleanArray(26)
    val hasUpper = BooleanArray(26)

    word.forEach { char ->
        if (char in 'a'..'z') {
            hasLower[char - 'a'] = true
        } else if (char in 'A'..'Z') {
            hasUpper[char - 'A'] = true
        }
    }

    for (i in 0 until 26) {
        if (hasLower[i] && hasUpper[i]) {
            count++
        }
    }

    return count
}

fun main() {
    val input = "aaAbcBC"
    println("The number of special chars are ${numberOfSpecialChars(input)}")
}