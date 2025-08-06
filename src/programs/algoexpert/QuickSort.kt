package programs.algoexpert


fun main() {
    val input = mutableListOf(8,5,2,9,5,6,3)
    print(quickSort(input))
}

private fun quickSort(array: MutableList<Int>): List<Int> {
    // Write your code here.
    sort(array,0,array.size -1)
    return array
}

private fun sort(array: MutableList<Int>, i: Int, j: Int) {
    var start = i
    var end = j
    val key = start + (end-start)/2
    while(start <= end) {

        while (array[start] < array[key]) {
            start++
        }
        while (array[end] > array[key]) {
            end--
        }

        if(start <= end){
            val temp = array[start]
            array[start] = array[end]
            array[end] = temp
            start++
            end--
        }


        if (start < j)
            sort(array,start, j)
        if (i < end)
            sort(array,i, end)
    }
}
