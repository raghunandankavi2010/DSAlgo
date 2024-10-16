package programs.arrays

import kotlin.math.max

/**
 * Knapsack problem recursive approach
 */
fun main() {
    val profit = intArrayOf(60, 100, 120)
    val weight = intArrayOf(10, 20, 30)
    val capacity = 50
    val n = profit.size
    println(knapSack(0, capacity, weight, profit, n))
}

private fun knapSack(index: Int, capacity: Int, weight: IntArray, profit: IntArray, n: Int): Int {
    if (index >= n) return 0

    // Exclude the current item
    var maxProfit = knapSack(index + 1, capacity, weight, profit, n)

    // Include the current item
    val newCapacity = capacity - weight[index]
    if (newCapacity >= 0) {
        val currentProfit = profit[index] + knapSack(index + 1, newCapacity, weight, profit, n)
        maxProfit = max(maxProfit, currentProfit)
    }

    return maxProfit
}
