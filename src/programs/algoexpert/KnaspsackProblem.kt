package programs.algoexpert

import kotlin.math.max


fun knapsackProblem(items: List<List<Int>>, capacity: Int): Pair<Int, List<Int>> {
    val memo = mutableMapOf<Pair<Int, Int>, Int>() // Memoization cache
    val selectedItems = mutableListOf<Int>()

    fun dfs(index: Int, remainingCapacity: Int): Int {
        if (index >= items.size || remainingCapacity <= 0)
            return 0

        if (memo.containsKey(index to remainingCapacity))
            return memo[index to remainingCapacity]!!

        // Exclude the current index item
        val excludeProfit = dfs(index + 1, remainingCapacity)

        // Include the current index item
        val includeProfit = if (items[index][1] <= remainingCapacity) {
            items[index][0] + dfs(index + 1, remainingCapacity - items[index][1])
        } else {
            0
        }

        val maxProfit = max(excludeProfit, includeProfit)
        memo[index to remainingCapacity] = maxProfit
        return maxProfit
    }

    val maxProfit = dfs(0, capacity)

    // Reconstruct the selected items
    var remainingCapacity = capacity
    for (index in 0 until items.size) {
        if (dfs(index, remainingCapacity) != dfs(index + 1, remainingCapacity)) {
            selectedItems.add(index)
            remainingCapacity -= items[index][1]
        }
    }

    return maxProfit to selectedItems
}

fun main() {
    val listOfLists: List<List<Int>> = listOf(
        listOf(1, 2),
        listOf(4, 3),
        listOf(5, 6),
        listOf(6, 7)
    )

    val capacity = 10

    val (profit, selectedItems) = knapsackProblem(listOfLists, capacity)
    println("Max profit: $profit")
    println("Selected items indices: $selectedItems")
}
