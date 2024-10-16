package programs.arrays

/**
 * Given input array 3,4,5,0,1,2
 * The array is rotated and sorted
 * Rotated by 3 position at index 3 with min value 0
 *
 */
fun main() {
    val input = intArrayOf(3,4,5,0,1,2)
    val isSortedRotated = checkSortedRotated(input)
    println(isSortedRotated)
}

fun checkSortedRotated(input: IntArray): Boolean {

    // find min element
    val min = input.minOrNull()
    // find index of min element
    val index = min?.let { input.indexOf(it) }

    // check if elements from 0 to min element are in increasing order
    var flag1 = true
    for(i in 1 until index!!){
        if(input[i]<input[i-1]){
            flag1 = false
            break
        }
    }

    // check if elements from min element + 1 to array length is in increasing order
    var flag2 = true
    for(i in index+1 until input.size){
        if(input[i]<input[i-1]){
            flag2 = false
            break
        }
    }

    // if array is rotated the first element is greater then last element
    return flag1 && flag2 && input[input.size-1] < input[0]
}
