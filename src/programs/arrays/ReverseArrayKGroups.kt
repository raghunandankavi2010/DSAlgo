package programs.arrays

import kotlin.math.min


fun main() {
    val n = 5
    val k = 3
    val arr = arrayOf(1,2,3,4,5)
    reverseInGroups(arr,n,k)
}

    fun reverseInGroups(arr: Array<Int>, n: Int, k: Int) {

        for ( i in arr.indices step k) {
            val right = min(i + k -1, n-1)
            swap(i, right, arr)
        }
       arr.forEach {
           println(it)
       }

    }


fun swap( startIndex: Int, endIndex: Int, arr: Array<Int>) {

    var start = startIndex
    var end = endIndex
    while(start < end) {
        arr[start] = arr[start] xor arr[end]
        arr[end] = arr[end] xor arr[start]
        arr[start] = arr[start] xor arr[end]
        start++
        end--
    }

}

