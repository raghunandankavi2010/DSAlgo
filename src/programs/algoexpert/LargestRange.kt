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

private fun largestRangeOptimized(array: List<Int>): Pair<Int, Int> {
    if (array.isEmpty()) {
        return Pair(-1,-1)
    }

    var longestRange = emptyList<Int>()
    var maxLength = 0

    val numMap = mutableMapOf<Int, Boolean>()
    for (num in array) {
        numMap[num] = false
    }

    for (num in array) {
        if (numMap[num] == true) {
            continue
        }

        numMap[num] = true
        var currentLength = 1

        var left = num - 1
        while (numMap.containsKey(left)) {
            numMap[left] = true // Mark as visited
            currentLength++
            left--
        }

        var right = num + 1
        while (numMap.containsKey(right)) {
            numMap[right] = true // Mark as visited
            currentLength++
            right++
        }

        if (currentLength > maxLength) {
            maxLength = currentLength
            longestRange = listOf(left + 1, right - 1)
        }
    }

    return Pair(longestRange[0],longestRange[1])

}