package programs.numbers


fun main() {
    var x = 2.0
    val n = 10

    if(n < 0) {
        x = 1/x
    }
    val result = power(x,Math.abs(n), 1.0)
    println(String.format("%.5f", result))
}

fun power(x: Double, n: Int, result: Double): Double {
    if(n == 0) {
       return result
    }

    var res = result
    res *=  x
    return power(x,n-1,res)
}
