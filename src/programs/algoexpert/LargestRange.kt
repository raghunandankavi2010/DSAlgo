package programs.algoexpert

fun main() {
    val array = listOf(1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6)
    val result = largestRange(array)
    print(result)
}

private fun largestRange(array: List<Int>): List<Int> {
    if (array.isEmpty()) {
        return emptyList()
    }
    val sortedArray = array.sorted()
    var longestRange = listOf(sortedArray[0], sortedArray[0])

    var currentStart = sortedArray[0]

    for (i in 1 until sortedArray.size) {
        val currentNum = sortedArray[i]
        val prevNum = sortedArray[i - 1]

        if (currentNum != prevNum + 1) {
            val currentRangeLength = prevNum - currentStart + 1
            val maxRangeLength = longestRange[1] - longestRange[0] + 1

            if (currentRangeLength > maxRangeLength) {
                longestRange = listOf(currentStart, prevNum)
            }
            currentStart = currentNum
        }
    }

    val lastElement = sortedArray.last()
    val lastRangeLength = lastElement - currentStart + 1
    val maxRangeLength = longestRange[1] - longestRange[0] + 1

    if (lastRangeLength > maxRangeLength) {
        longestRange = listOf(currentStart, lastElement)
    }

    return longestRange
}