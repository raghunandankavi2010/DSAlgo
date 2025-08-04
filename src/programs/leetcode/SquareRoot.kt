package programs.leetcode

fun main() {
    val x = 8
    val output = mySqrt(x)
    println(output)
}

private fun mySqrt(x: Int): Int {

    if(x == 0) return 0

    var start = 1
    var end = x

    while(end >= start) {
        val mid = start+(end-start)/2
        val square = mid.toLong() * mid.toLong()
        if(square == x.toLong()) {
            return mid
        } else if(square < x.toLong()) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return end
}