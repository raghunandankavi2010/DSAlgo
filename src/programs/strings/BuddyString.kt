package programs.strings

/**
 * https://leetcode.com/problems/buddy-strings/
 */
fun main() {

    val a = "abab"
    val b = "baab"
    println(isBuddyString(a, b))
}

private fun isBuddyString(A: String, B: String): Boolean {
    when {
        A.length != B.length -> {
            return false
        }
        A == B -> {
            val set = mutableSetOf<Char>()
            A.forEach {
                if (set.contains(it))
                    return true
                set.add(it)
            }
            return false
        }
        else -> {
            val list = mutableListOf<Int>()
            for (i in A.indices) {
                if (A[i] != B[i]) {
                    list.add(i)
                }
            }
            return list.size == 2 && A[list[0]] == B[list[1]] && A[list[1]] == B[list[0]]

        }
    }
}


