package programs.algoexpert


fun main() {
    val n = 5
    val result = getNthFib(n)
    println(result)
}

private fun getNthFib(n: Int): Int {
    if (n <= 1) return 0
    if (n == 2) return 1

    var prev = 0
    var curr = 1


    for(i in 3.. n) {
        val nextFib = prev + curr
        prev = curr
        curr = nextFib
    }

    return curr
}
