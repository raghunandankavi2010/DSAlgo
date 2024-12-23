package programs.algoexpert

fun kadanesAlgorithm(array: List<Int>): Int {
    var currentMax = array[0]
    var globalMax = array[0]

    for (i in 1 until array.size) {
        currentMax = Math.max(array[i], currentMax + array[i])
        if (currentMax > globalMax) {
            globalMax = currentMax
        }
    }
    return globalMax
}

fun main() {
    val arr = arrayOf(3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4)
    val list = arr.toList()
    println(kadanesAlgorithm(list)) // Output should be the maximum sum of contiguous subarray
}
