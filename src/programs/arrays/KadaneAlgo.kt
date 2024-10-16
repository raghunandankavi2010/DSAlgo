package programs.arrays

fun main() {
    val array = arrayOf(-2, -3, 4, -1, -2, 1, 5, -3)

    var currSum = 0
    var maxSum = 0
    var start = 0
    var end = 0
    var sIndex = 0
    array.forEachIndexed { index, element ->
        currSum += element

        if (currSum > maxSum) {
            maxSum = currSum
            start = sIndex
            end = index
        }

        if (currSum < 0) {
            currSum = 0
            sIndex = index + 1
        }
    }

    println(maxSum)
    println("Start Index: $start")
    println("End Index: $end")
}