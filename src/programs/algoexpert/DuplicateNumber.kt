package programs.algoexpert

/**
 * Given an array of integers between 1 to n find the first duplicate number
 */

fun main() {
    val arr = mutableListOf(2, 1, 5, 3, 3, 2, 4)
    print(firstDuplicateValue(arr))

}

private fun firstDuplicateValue(array: MutableList<Int>): Int {
    var duplicateNum = -1
    for (i in 0 until array.size) {
        val index = kotlin.math.abs(array[i]) - 1
        if (index >= array.size) continue  // Skip if index is out of bounds

        if (array[index] < 0) {
            duplicateNum = index + 1
            break
        } else {
            array[index] = -array[index]
        }
    }
    return duplicateNum
}
