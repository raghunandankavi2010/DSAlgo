package programs.numbers

import kotlin.math.floor
import kotlin.math.sqrt

fun main(){
    val num = 144
    val check = isPerfectSquare2(num)
    println(check)
}
fun isPerfectSquare2(x: Int): Boolean {

    // Find floating point value of
    // square root of x.
    val sr = sqrt(x.toDouble())

    // If square root is an integer
    return sr - floor(sr) == 0.0
}

fun isPerfectSquare(num: Int): Boolean {

    var l = 1
    var r = num
    while(l<=r){
        val mid = (l+r)/2
        val squaredMid = mid * mid
        println(squaredMid)
        when {
            squaredMid == num ->  {
                println("Perfect square $squaredMid")
                return true
            }
            squaredMid > num -> {
                r = mid-1
            }
            else -> {
                l  = mid+1
            }
        }
    }
    return false
}
