package programs.algoexpert

fun countWaysRecursive(coins: IntArray, amount: Int): Int {

    var min = Integer.MAX_VALUE
    fun solve(index: Int, currentAmount: Int): Int {

        if (currentAmount == 0) {
            return 1
        }


        if (index >= coins.size || currentAmount < 0) {
            return 0
        }


        val waysIfIncluded = solve(index, currentAmount - coins[index])


        val waysIfExcluded = solve(index + 1, currentAmount)


        return waysIfIncluded +  waysIfExcluded
    }

    return solve(0, amount)
}

fun main() {
    val coins = intArrayOf(1, 2,5)
    val n = 11
    val ways = countWaysRecursive(coins, n)
    println("Pure Recursion: There are $ways ways to make change for $n.")
}