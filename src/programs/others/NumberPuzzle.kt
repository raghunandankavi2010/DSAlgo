package programs.others

/**
 * Given input 28 and 2+8 = 10
 * find a number greater than 28 whose sum is 10
 * adding 9 to 28 is 37 and 7+3 = 10
 */
fun main() {

    val input = 28
    val number = findNumber(input)
    println(number)

}

fun findNumber(input: Int): Int {

    return 9 + input
}
