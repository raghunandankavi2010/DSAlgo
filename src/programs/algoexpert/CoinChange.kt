package programs.algoexpert

fun countWaysRecursive(coins: IntArray, amount: Int): Int {

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
    val coins = intArrayOf(1, 5, 10)
    val n = 7
    val ways = findMinimumCoins(coins, n)
    println("Pure Recursion: There are $ways ways to make change for $n.")
}

fun findMinimumCoins(coins: IntArray, amount: Int): Int {

    val result = minWaysRecursive(coins, amount, 0)

    return if (result == Int.MAX_VALUE) {
        -1
    } else {
        result
    }
}

fun minWaysRecursive(coins: IntArray, amount: Int, index: Int): Int {

    if(amount == 0) return 0

    if (index >= coins.size || amount < 0) {
        return Integer.MAX_VALUE
    }

    val resIfIncluded = minWaysRecursive(coins, amount - coins[index], index)
    val coinsIfIncluded = if (resIfIncluded != Int.MAX_VALUE) {
        1 + resIfIncluded
    } else {
        Int.MAX_VALUE
    }

    val ifNotIncluded = minWaysRecursive(coins, amount , index+1 )

    return minOf(coinsIfIncluded,ifNotIncluded)

}