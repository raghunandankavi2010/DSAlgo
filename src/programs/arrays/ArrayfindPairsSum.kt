package programs.arrays

import kotlin.jvm.JvmStatic
import java.util.Arrays
import java.util.HashMap

object ArrayfindPairsSum {
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(11, 11, 11, 12, 55)
        //int sum = 23;
        //getPairsCount(arr, sum);
        val arrUnsorted = intArrayOf(10, 1, 1)
        val total = 11

        //findPairsEqualToSum(arrUnsorted,total);
        // findPairsEqualToSumHashMap(arrUnsorted, total);
        getPairsCountDuplicate(arrUnsorted, arrUnsorted.size, total)

        val a = intArrayOf(0, -1, 2, -3, 1, 3, 3)
        val x = 6

        println(isfindPair(a, x))
    }

    // Prints number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    private fun getPairsCount(arr: IntArray, sum: Int) {

        //int count = 0;// Initialize result

        // Consider all possible pairs and check their sums
        for (i in arr.indices) for (j in i + 1 until arr.size) if (arr[i] + arr[j] == sum) {
            println("pairs" + arr[i] + " " + arr[j])
            // count++;
        }

        //System.out.printf("Count of pairs is %d", count);
    }

    // Method Two
    // 1. sort the array
    // 2. have two pointers pointing to start and end of array
    // 3. increment start if arr[start]+arr[end] is less than sum
    // 4. decrement end if arr[start]+arr[end] is greater than sum
    // 5. if equal print pair and increment start and decrement end
    // 6. repeat above until start<end
    private fun findPairsEqualToSum(arr: IntArray, sum: Int) {
        Arrays.sort(arr)
        var start = 0
        var end = arr.size - 1
        while (start < end) {
            if (arr[start] + arr[end] > sum) {
                end--
            } else if (arr[start] + arr[end] < sum) {
                start++
            } else if (arr[start] + arr[end] == sum) {
                println("pairs : " + arr[start] + " " + arr[end] + " Sum is: " + (arr[start] + arr[end]))
                start++
                end--
            }
        }
    }

    private fun getPairsCountDuplicate(arr: IntArray, n: Int, sum: Int) {
        val mp: MutableMap<Int, Int> = HashMap()

        // Traverse through all elements
        for (i in 0 until n) {

            // Search if a pair can be formed with
            // arr[i].
            val rem = sum - arr[i]
            if (mp.containsKey(rem)) {
                val count = mp.getOrDefault(rem,0)
                for (j in 0 until count)
                    print("""($rem, ${arr[i]})""".trimIndent())
            }
            if (mp.containsKey(arr[i])) {
                mp[arr[i]] = mp[arr[i]]!! + 1
            } else {
                mp[arr[i]] = 1
            }
        }
    }

    private fun findPairsEqualToSumHashMap(arr: IntArray, sum: Int) {
        val map = HashMap<Int, Int>()
        for (i in 0 until arr.size - 1) {
            map[arr[i]] = arr[i]
        }
        for (i in 0 until arr.size - 1) {
            // number + x = sum
            // sum - number = x
            // check if map contains that number
            // check if that number and arr[i] total to sum given
            // print the value in map and arr[i]
            if (map.containsKey(sum - arr[i])) {
                val x = map[sum - arr[i]]!!
                if (x + arr[i] == sum) {
                    println("Pairs :" + x + " " + arr[i])
                }
            }
        }
    }
    fun isfindPair(array: IntArray, sum: Int): Boolean {
        val mp: MutableMap<Int, Int> = HashMap()

        var check = false
        for (i in array.indices) {

            val rem: Int = sum - array[i]
            check = if (mp.containsKey(rem)) {
                val count = mp.getOrDefault(rem, -1)
                true
            } else {
                false
            }
            if (mp.containsKey(array[i])) {
                mp[array[i]] = mp.getOrDefault(array[i], 0) + 1
            } else {
                mp[array[i]] = 1
            }
        }
        return check
    }
}