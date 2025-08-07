package programs.algoexpert

fun main() {

    val input = mutableListOf(45, 61, 71, 72, 73, 0, 1, 21, 33, 37)
    val target = 0
    val output = shiftedBinarySearch(input, target)
    if (output != -1) {
        println("Target $target found at index $output")
    } else {
        println("Target index not found in array")
    }

}

private fun shiftedBinarySearch(array: List<Int>, target: Int): Int {

    if (array.isEmpty()) return -1
    if (array.size == 1 && array[0] == target) return 0

    val pivotIndex = findPivot(list = array, i = 0, j = array.size - 1)

    if (pivotIndex == -1) {
        return doBinarySearch(array, 0, array.size - 1, target)
    }

    if (array[pivotIndex] == target) {
        return pivotIndex
    }

    if (array[0] <=  target ) {
        return doBinarySearch(array, 0, pivotIndex - 1, target)
    }

    return doBinarySearch(array, pivotIndex + 1 , array.size - 1, target)

}

private fun doBinarySearch(array: List<Int>, i: Int, j: Int, target: Int): Int {

    var start = i
    var end = j

    while (start <= end) {
        val mid = start + (end - start) / 2
        if (array[mid] == target) {
            return mid
        } else if (target < array[mid]) {
            end = mid - 1
        } else {
            start = mid + 1
        }
    }

    return -1
}

private fun findPivot(list: List<Int>, i: Int, j: Int): Int {

    // base cases
    val start = i
    val end = j
    val mid = start + (end - start) / 2

    if (end < start) return -1
    if (end == start) return start

    if (mid < end && list[mid] > list[mid + 1])
        return mid
    if (mid > start && list[mid] < list[mid - 1])
        return (mid - 1)
    if (list[start] >= list[mid])
        return findPivot(list, start, mid - 1)
    return findPivot(list, mid + 1, end)

}

