package programs.algoexpert

fun main() {
    val array = intArrayOf(1, 0, 0, -1, -1, 0, 1, 1).toMutableList()
    val order = intArrayOf(0, 1, -1).toList()

    print(threeNumberSort(array,order))
}

private fun threeNumberSort(array: MutableList<Int>, order: List<Int>): List<Int> {
    // Write your code here.

    var start = 0
    var mid = 0
    var end =   array.size - 1
    val firstNum = order[0]
    val midNum =  order[1]

    while (mid <= end) {
        val value = array[mid]

        when (value) {
            firstNum -> {
               val temp = array[start]
                array[start] = array[mid]
                array[mid] = temp
                start++
                mid++
            }
            midNum -> {
                mid++
            }
            else -> {
                val temp = array[mid]
                array[mid] = array[end]
                array[end] = temp
                end--
            }
        }
    }
    return array
}
