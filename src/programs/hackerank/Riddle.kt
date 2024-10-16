package programs.hackerank

import java.util.*
import kotlin.math.max

fun main() {
    val arr = arrayOf(10, 20, 30, 50, 10, 70, 30)
    val output = riddle(arr)

    // Print the result
    for (i in 1 until output.size) {
        print("${output[i]} ")
    }
}

// 1 Find the smaller element to the right of current element
// 2 Find the smaller element to the left of current element
// If in step i you find a greater element on stack pop
// add index to stack
// repeat the above for right side
fun riddle(arr: Array<Int>): IntArray {
    val n = arr.size

    val s = Stack<Int>()

    val left = IntArray(n + 1) { -1 }
    val right = IntArray(n + 1) { n }


    for (i in 0 until n) {
        while (!s.empty() && arr[s.peek()] >= arr[i]) s.pop()
        if (!s.empty()) left[i] = s.peek()
        s.push(i)
    }

    while (!s.empty()) s.pop()

    for (i in n - 1 downTo 0) {
        while (!s.empty() && arr[s.peek()] >= arr[i]) s.pop()
        if (!s.empty()) right[i] = s.peek()
        s.push(i)
    }

    val ans = IntArray(n + 1) { 0 }

    for (i in 0 until n) {
        val len = right[i] - left[i] - 1
        ans[len] = max(ans[len], arr[i])
    }


    for (i in n - 1 downTo 1) {
        ans[i] = max(ans[i], ans[i + 1])
    }

    return ans

}