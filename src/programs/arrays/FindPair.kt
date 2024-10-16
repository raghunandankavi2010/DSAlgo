package programs.arrays

import java.util.HashMap

/**
 *  Find pairs whose sum is K given an array of integers
 *  Do it in one pass
 *  One way is to sort array and then increment low and high based on sum greater os lesser than k
 */
fun main() {
    val intArray = intArrayOf(10,25,0,5,7,20,3)
    val k = 3

    val complementMap: HashMap<Int, Int> = HashMap()

    for (i in intArray.indices) {
        val curr: Int = intArray[i]
        if (complementMap.containsKey(k - curr)) {
          println("Pair is $curr ${complementMap[k - curr]}")
            break
        }
        complementMap[curr] = curr
    }

}