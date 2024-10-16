package programs.leetcode

import kotlin.math.max
import kotlin.math.min

/**
 * Given n non-negative integers
 * representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
fun main(){
    val arr = intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)
    val water = trappedWater(arr)
    println(water)
}

/**
 * Find the max height to the left of current index
 * Find the max height to the right of current index
 * water is min of(height at left of current index, height at right of current index) - height at current index
 * if input in 1,2,3,4 water cannot be trapped
 * if input is just 2 water cannot be trapped ( need two walls and one empty block to trap water)
 */
fun trappedWater(arr: IntArray) : Int {

    val n = arr.size
    if(n < 3){
        return 0
    } else {

        val left = Array(n) { 0 }

        val right = Array(n) { 0 }

        left[0] = arr[0]
        for (i in 1 until arr.size) {
            left[i] = max(left[i - 1], arr[i])
        }

        right[n - 1] = arr[n - 1]
        for (i in n - 2 downTo 0) {
            right[i] = max(right[i + 1], arr[i])
        }

        var water = 0

        arr.forEachIndexed { index, element ->
            water += min(left[index], right[index]) - element

        }
        return water
    }

}