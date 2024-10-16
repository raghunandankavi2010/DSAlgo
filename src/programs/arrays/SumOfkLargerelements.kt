package programs.arrays

import java.util.*


fun main() {

    //12 6 4
    val array = intArrayOf(12, 3, 4, 1, 6, 9,20)
    val k = 3
    val minHeap = PriorityQueue<Int>()
    var index = 0
    var count = 0
    while (count < k && index < array.size) {
        if (array[index] % 2 == 0) {
            minHeap.add(array[index])
            count++
        }
        index++
    }

    for (i in index until array.size) {
        if (minHeap.peek() > array[i]) continue else {
            if (array[i] % 2 == 0 && !minHeap.contains(array[i])) { // contains check is to avoid duplicates
                minHeap.poll()
                minHeap.add(array[i])
            }
        }
    }
    var max = 0

    val iterator: Iterator<Int> = minHeap.iterator()

    while (iterator.hasNext()) {
        max += iterator.next()
    }

    println(max)
}