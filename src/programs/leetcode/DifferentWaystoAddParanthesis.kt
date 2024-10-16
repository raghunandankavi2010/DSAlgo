package programs.leetcode


fun main() {
    val expression = "2-1-1"

    diffWaysToCompute(expression).forEach {
        println(it)
    }
}

fun diffWaysToCompute(expression: String?): List<Int> {
    return solve(expression!!)
}

fun solve(expression: String): List<Int> {
    val result = mutableListOf<Int>()

    expression.forEachIndexed { index, currChar ->
        if (currChar == '+' || currChar == '-' || currChar == '*') {
            val left = solve(expression.substring(0, index))
            val right = solve(expression.substring(index + 1))
            for (x in left) {
                for (y in right) {
                    when (currChar) {
                        '+' -> {
                            result.add(x + y)
                        }

                        '-' -> {
                            result.add(x - y)
                        }

                        else -> {
                            result.add(x * y)
                        }
                    }
                }
            }
        }
    }

    if (result.isEmpty()) {
        result.add(Integer.parseInt(expression))
    }
    return result
}


