package programs.arrays

import java.util.PriorityQueue

/** 347. Top K Frequent Elements
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *  Example 1:

 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:

 * Input: nums = [1], k = 1
 * Output: [1]
 */
fun main() {
    val input = arrayOf<Int>(1, 1, 1, 2, 2, 3)
    val k = 2
    val output = topKFrequent(input.toIntArray(), k)
    output.forEach {
        println(it)
    }

}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    val map = HashMap<Int, Int>()

    nums.forEach {
        if (!map.containsKey(it)) {
            map[it] = 1
        } else {
            val currentCount = map.getOrDefault(it, 1) + 1
            map[it] = currentCount
        }
    }
    val pq = PriorityQueue { a: IntArray, b: IntArray ->
        Integer.compare(
            a[1],
            b[1]
        )
    }
    map.forEach { (key, value) ->
        pq.add(intArrayOf(key, value))
        while (pq.size > k) {
            pq.poll()
        }
    }
    val result = IntArray(k)
    for (i in 0 until k) {
        result[i] = pq.poll()[0]
    }

    return result
}