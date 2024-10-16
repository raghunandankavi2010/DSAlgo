package programs.arrays

import java.util.*

/**
 * This is from geeks for geeks
 */
class RemoveDuplicate {


    companion object {
        // Function to remove duplicate elements
        // This function returns new size of modified
        // array.
        private fun removeDuplicates(arr: IntArray, n: Int): Int {
            // Return, if array is empty
            // or contains a single element
            if (n == 0 || n == 1) return n
            val temp = IntArray(n)

            // Start traversing elements
            var j = 0
            for (i in 0 until n - 1) {
                // If current element is not equal
                // to next element then store that
                // current element
                if (arr[i] != arr[i + 1]) temp[j++] = arr[i]
            }

            // Store the last element as whether
            // it is unique or repeated, it hasn't
            // stored previously
            temp[j++] = arr[n - 1]

            // Modify original array
            if (j >= 0) System.arraycopy(temp, 0, arr, 0, j)
            return j
        }

        @JvmStatic
        fun main(args: Array<String>) {

            val iarr = intArrayOf(1, 2)
            println(removeDuplicates(iarr))

//            val array = intArrayOf(1, 2, 2, 3, 4, 4, 4, 5, 5)
//            removeDuplicatesStdFun(array)
//            countDuplicatesUsingMap(array)
//
//            val arrSize = array.size
//            printRepeating(array, arrSize)
//            findRepeat(array)
//
//
//            val arr = intArrayOf(1, 2, 2, 3, 4, 4, 4, 5, 5)
//            var n = arr.size
//            n = removeDuplicates(arr, n)
//
//
//            for (i in 0 until n) print(arr[i].toString() + " ")
        }

        //1,1,2

        private fun removeDuplicates(nums: IntArray): Int {
            var count = 0
            var index = 0
            for (i in nums.indices) {
                if (i < nums.size - 1 && nums[i] == nums[i + 1]) continue
                nums[index] = nums[i]
                index++
                count++

            }
            return count
        }

        private fun removeDuplicatesStdFun(array: IntArray) {

            val distinct = array.distinct()
            println("Array without duplicates $distinct")
        }

        private fun printRepeating(arr: IntArray, size: Int) {
            val count = IntArray(size)

            /*
               4 (count 1),2 (count 1), 4 (count already 1 so dup), 5 (count 1) , 2 (count already 1 so dup), 3 (count 1) , 1 (count 1)
               count[0] = 0, count[2] = 1, count[3] = 1 ,count[4] = 1, count[5] = 1, count[6] = 0
             */println("Repeated elements are : ")
            var i = 0
            while (i < size) {
                if (count[arr[i]] == 1) {
                    println("Repeated " + arr[i])
                } else {
                    count[arr[i]] = count[arr[i]] + 1
                }
                i++
            }
            // for logging purpose. Not required
            i = 0
            while (i < size) {
                println("Number :" + arr[i] + " Count at pos " + count[i])
                i++
            }
        }

        // find duplicates using HashSet.
        private fun findRepeat(numbers: IntArray): Int {
            val numbersSeen: MutableSet<Int> = HashSet()
            for (number in numbers) {
                if (numbersSeen.contains(number)) {
                    return number
                } else {
                    numbersSeen.add(number)
                }
            }
            throw IllegalArgumentException("no duplicate!")
        }

        private fun countDuplicatesUsingMap(data: IntArray) {

            val map = mutableMapOf<Int, Int>()
            for (i in data.indices) {
                if (!map.containsKey(data[i])) {
                    map[data[i]] = 1
                } else {
                    map.computeIfPresent(data[i]) { _, value -> value + 1 }
                }
            }


            map.forEach { (k, v) ->
                if (v > 1) {
                    println("$k = $v")
                }
            }

            val maxValue = map.maxByOrNull { it.value }

            println("Maximum repeated value $maxValue")
        }
    }


}