package programs.leetcode

import kotlin.math.abs

var res = 0.0
fun main() {
    val output = pow(2.0,5)
    val res = iterativeApproach(2.0,-2)
    println(res)
}

private fun pow(x: Double, n: Int): Double {

   res =  helper(x,abs(n))
    return if(n >=0) res else 1/res

}

private fun helper(x: Double, n: Int): Double {
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

private fun iterativeApproach(x: Double, n: Int): Double {
    var res = 1.0
    repeat(abs(n)) {
            res *= x
    }
    return if(n >= 0)  res else  1/res

}