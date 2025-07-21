package programs.algoexpert


fun moveElementToEnd(array: MutableList<Int>, toMove: Int): List<Int> {
    // Write your code here.

    var end = array.size - 1
    var start = 0
    while (start <= end) {
        if (array[start] == toMove) {
            if(array[end] == toMove) {
                end--
            } else {
                val temp = array[start]
                array[start] = array[end]
                array[end] = temp
                start++
                end--
            }
        } else {
            start++
        }
    }
    return array
}


fun main() {

    val input = mutableListOf(2,1)
    print(moveElementToEnd(input, 2))
}

