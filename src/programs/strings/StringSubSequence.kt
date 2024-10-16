package programs.strings

/**
 * Given a String find all subsequences of given length k
 * Given String s = "ab int k = 2
 * ab ba are subsequences of length 2
 * without duplicates
 */
fun main() {
    var inputString = "aabcc"
    var withoutRepeated = ""
    val set = HashSet<Char>()
    for(char in inputString) {
        if(set.add(char))
            withoutRepeated+= char
    }
    inputString = withoutRepeated
    permuteSubSequence(inputString)
}

fun permuteSubSequence(inputString: String) {
    permute("", inputString, 3)
}

private fun permute(perm: String, word: String, k: Int) {
    if (k == 0) {
        println(perm)
    } else {
        for (i in word.indices) {
            permute(perm + word[i], word.substring(0, i) + word.substring(i + 1), k - 1)
        }
    }
}