package programs.arrays

/**
 *  Leet code 121
 *  121. Best Time to Buy and Sell Stock
Easy

19315

623

Add to List

Share
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
Example 2:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104

 */
fun main() {

    val arr = intArrayOf(7,6,4,3,1)
    val maxP = maxProfit(arr)
    println("Max profit is $maxP")
}

private fun maxProfit(prices: IntArray): Int {
    var left = 0
    var right = 1
    var maxP = 0
    while(right < prices.size ) {
        if(prices[left] < prices[right]) {
            val profit = prices[right] - prices[left]
            maxP = Math.max(maxP, profit)
        } else {
            left = right
        }
        right ++
    }
    return maxP

}