package programs.hackerank

import java.util.*

/**
 * https://www.hackerrank.com/challenges/2d-array/problem
 */

fun hourglassSum(arr: Array<Array<Int>>): Int {

    val sum: MutableList<Int> = ArrayList()
    for (i in 0..3) {
        for (j in 0..3) {
            sum.add(arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j] + arr[i + 2][j + 1] + arr[i + 2][j + 2])
        }
    }
    return Collections.max(sum)
}

fun main() {
    val scan = Scanner(System.`in`)

    val arr = Array(6) { Array(6) { 0 } }

    for (i in 0 until 6) {
        arr[i] = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()
    }

    val result = hourglassSum(arr)

    println(result)
}
