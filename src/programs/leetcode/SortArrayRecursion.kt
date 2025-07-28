package programs.leetcode

class SortArrayRecursion {

    fun sortArray(array: IntArray): IntArray {
        recurseSort(array,0)
        return array
    }

    fun recurseSort(array: IntArray, i: Int) {
        if(i == array.size) return
        var j = i
        while(j > 0 && array[j-1] > array[j]) {
            val temp = array[j-1]
            array[j-1] = array[j]
            array[j] = temp
            j--
        }

        recurseSort(array, i +1)
    }

}

fun main() {
    val array = intArrayOf(5,2,3,1)
    val sortArrayRecursion = SortArrayRecursion()
    val output = sortArrayRecursion.sortArray(array)
    print(output.toList())
}