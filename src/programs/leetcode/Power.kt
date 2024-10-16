package programs.leetcode

import kotlin.math.abs

var res = 0.0
fun main() {
    val output = pow(2.0,5)
    println(output)
}

fun pow(x: Double, n: Int): Double {

   res =  helper(x,abs(n))
    if(n >=0) return res else return 1/res

}

fun helper(x: Double, n: Int): Double {
    if(x == 0.0) return 0.0
    if(n== 0) return 1.0
    res = helper(x, n/2)
    res *= res
    return if(n%2 == 0) {
        res
    } else {
        x * res
    }
}