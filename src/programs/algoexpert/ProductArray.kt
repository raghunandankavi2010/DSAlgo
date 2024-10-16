package programs.algoexpert


fun main() {
    val arr = listOf(5, 1, 4, 2)
    // left  ->  1    5    5    20
    // right ->  8    8    2    1

    val result = arrayOfProducts(arr)
    println(result)
}

private fun arrayOfProducts(array: List<Int>): List<Int> {
    // Write your code here.
    val outputArr = MutableList(array.size) { 1 }

    outputArr[0] = 1
    for (i in 1 until array.size) {
        outputArr[i] = outputArr[i - 1] * array[i-1]
    }

    var right = 1
    for (i in array.size - 1 downTo 0) {
        outputArr[i] = outputArr[i] * right
        right *= array[i]
    }

    return outputArr
}
