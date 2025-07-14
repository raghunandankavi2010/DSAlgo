package programs.leetcode

private val mapof = mapOf(
    "2" to "abc",
    "3" to "def",
    "4" to "ghi",
    "5" to "jkl",
    "6" to "mno",
    "7" to "pqrs",
    "8" to "tuv",
    "9" to "wxyz"
)

fun main() {
    val digits = "2"
    val output = letterCombinations(digits)
    println(output)
}

private fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) {
        return emptyList()
    }

    val result = mutableListOf<String>()
    combination(digits,result)
    return result
}

private fun combination(digits: String,result: MutableList<String>, index: Int = 0, comb: String = "") {
    if(comb.length == digits.length) {
        result.add(comb)
        return
    }

    if(index < digits.length ) {
        val currentString = digits[index].toString()
        val curr = mapof[currentString]

        curr?.forEach { char ->
            combination(digits, result, index + 1, comb + char)
        }
    }
}