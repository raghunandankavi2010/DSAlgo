package programs.leetcode

fun main() {
    val n = 1
    val k = 1

    println(combine(n, k))
}

fun combine(n: Int, k: Int): List<List<Int>> {
    val currentList = mutableListOf<Int>()
    val result = mutableListOf<List<Int>>()

    fun backtrack(start: Int) {
        if(currentList.size == k) {
            result.add(ArrayList(currentList))
            return
        }
        for (i in start..n) {
            currentList.add(i)
            backtrack(i + 1)
            currentList.removeAt(currentList.size - 1)
        }
    }

    backtrack(1)
    return result

}