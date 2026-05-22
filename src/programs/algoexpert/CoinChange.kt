/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
    val memo = Array(coins.size) { IntArray(amount + 1) { -1 } }

    val result = minWaysRecursive(coins, amount, 0, memo)

    return if (result == Int.MAX_VALUE) {
        -1
    } else {
        result
    }
}

fun minWaysRecursive(coins: IntArray, amount: Int, index: Int, memo: Array<IntArray>): Int {

    if(amount == 0) return 0

    if (index >= coins.size || amount < 0) {
        return Integer.MAX_VALUE
    }

    if (memo[index][amount] != -1) {
        return memo[index][amount]
    }

    val resIfIncluded = minWaysRecursive(coins, amount - coins[index], index, memo)
    val coinsIfIncluded = if (resIfIncluded != Int.MAX_VALUE) {
        1 + resIfIncluded
    } else {
        Int.MAX_VALUE
    }

    val ifNotIncluded = minWaysRecursive(coins, amount, index+1, memo)
    val minCoins = minOf(coinsIfIncluded,ifNotIncluded)

    memo[index][amount] = minCoins

    return minCoins

}