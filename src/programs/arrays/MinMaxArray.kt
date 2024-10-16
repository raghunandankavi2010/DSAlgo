package programs.arrays

/**
 * Asked in L&T
 * Given an array of unsorted array
 * 2, 4, 5, 6, 1, 30, 13, 25, 10
 * create another array with elements
 * firstMin,firstMax,secondMin,secondMax
 * output
 * 1,30,2,25
 * Complexity O(n)
 */
fun main() {
    val intArray = arrayOf(2, 4, 5, 6, 1, 30, 13, 25, 10)
    var firstMin = intArray[0]
    var secondMin = 0
    var firstMax = intArray[0]
    var secondMax = 0

    for (i in 1 until intArray.size) {
        // find firstMin
        if (intArray[i] < firstMin) {
            secondMin = firstMin
            firstMin = intArray[i]
        }
        // if there are other elements that are less than secondMin
        else if (intArray[i] < secondMin) {
            secondMin = intArray[i]
        }
        // first firstMax and secondMax
        if (intArray[i] > firstMax) {
            secondMax = firstMax
            firstMax = intArray[i]
        } else if (intArray[i] > secondMax) {
            secondMax = intArray[i]
        }
    }

    val outputArray = arrayOf(firstMin, firstMax, secondMin, secondMax)
    outputArray.forEach {
        print(" $it")
    }
}