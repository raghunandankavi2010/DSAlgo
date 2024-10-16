package programs.others


fun main() {
    val n = 8
    println(findPowerOfTwo(n))
}

fun findPowerOfTwo(number: Int): Boolean {
    val n = number
    if (n == 1)
        return true

    if (n % 2 != 0 || n == 0)
        return false

    return findPowerOfTwo(n / 2)

}
