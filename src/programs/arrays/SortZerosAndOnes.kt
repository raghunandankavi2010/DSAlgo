package programs.arrays

import java.util.*

/**
 * Sort array of zeros and 1
 */

fun main() {
    val array = arrayOf(1, 0, 1, 1, 0, 1, 0, 0)
    bubbleSort(array)
    sortArray(array)



}

fun sortArray(array: Array<Int>) {
    var left = 0
    var right = array.size -1
    while(left < right) {
        if(array[left] == 1) {
            val temp = array[left]
            array[left] = array[right]
            array[right] = temp
            right --
        } else {
            left ++
        }
    }
    println(array.contentToString())
}

fun bubbleSort(array: Array<Int>) {
    val n = array.size - 1
    for(i in 0.. n) {
        for( j in 0.. n-(i+1)) {
            if(array[j] >= array[j+1]) {
                val temp = array[j]
                array[j] = array[j+1]
                array[j+1] = temp
            }
        }
    }
    println(array.contentToString())
}