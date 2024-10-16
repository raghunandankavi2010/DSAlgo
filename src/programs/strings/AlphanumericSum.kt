package programs.strings

/**
 * Given alphanumeric string calculate the sum of digits
 * A1b2
 * sum here is 3
 * Also take into account continuous digit's can be bigger num
 */
fun main() {
    val str = "A1b23c3"
    val sum = alphaNumSum(str)
    println(sum)
}

fun alphaNumSum(str: String): Int {
    var sum = 0
    var temp = "0"
    str.forEach {
        if(it.isDigit()) {
            temp = "$temp$it"
        } else {
            sum += temp.toInt()
            temp = "0"
        }
    }
    sum += temp.toInt()
    return sum
}
