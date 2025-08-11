package programs.leetcode

fun main() {
    println("--- Test Case 1: n = 15 ---")
    var n1 = 15
    var queries1 = arrayOf(
        intArrayOf(0, 1),
        intArrayOf(2, 2),
        intArrayOf(0, 3)
    )
    var answers1 = productQueries(n1, queries1)
    println("Expected: [2, 4, 64]")
    println("Actual:   ${answers1.joinToString(prefix = "[", postfix = "]")}\n")


    println("--- Test Case 2: n = 2 ---")
    var n2 = 2
    var queries2 = arrayOf(
        intArrayOf(0, 0)
    )
    var answers2 = productQueries(n2, queries2)
    println("Expected: [2]")
    println("Actual:   ${answers2.joinToString(prefix = "[", postfix = "]")}\n")
}

fun productQueries(n: Int, queries: Array<IntArray>): IntArray {
    val MOD = 1_000_000_007

    val powers = mutableListOf<Int>()
    for (i in 0 until 31) {
        if ((n shr i) and 1 == 1) {
            powers.add(1 shl i)
        }
    }


    val answers = IntArray(queries.size)
    queries.forEachIndexed { index, query ->
        val start = query[0]
        val end = query[1]

        var product: Long = 1L

        for (i in start..end) {
            product = (product * powers[i]) % MOD
        }

        answers[index] = product.toInt()
    }

    return answers
}