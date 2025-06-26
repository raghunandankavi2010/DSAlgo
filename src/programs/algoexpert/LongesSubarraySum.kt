package programs.algoexpert

private fun longestSubarrayWithSum(array: List<Int>, targetSum: Int): List<Int> {
    // Write your code here.
    val list = mutableListOf<Int>()
    var currSum = 0
    var startingIndex = 0
    var endingIndex = 0

    if(array.isEmpty()) return listOf()
    while(endingIndex < array.size) {
        currSum += array[endingIndex]

        while(startingIndex < array.size && currSum > targetSum) {
            currSum -= array[startingIndex]
            startingIndex += 1
        }

        if(startingIndex <= endingIndex && currSum == targetSum) {
            if(list.isEmpty()) {
                list.add(startingIndex)
                list.add(endingIndex)
            } else if(list[1] - list [0] < endingIndex - startingIndex) {
                list[0] = startingIndex
                list[1] = endingIndex
            }
        }
        endingIndex += 1
    }
    return list
}

fun main() {
    val list = listOf(0)
    val targetSum = 0
    val result = longestSubarrayWithSum(list,targetSum)
    result.forEach {
        print(it)
    }
}