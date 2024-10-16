package programs.arrays

/**
 * Find the missing number in the given sequential array'
 */
object FindMissingNumber {
    @JvmStatic
    fun main(args: Array<String>) {
        val arr = intArrayOf(1, 2 , 4, 5, 6, 7, 8)
        val n = 9
        val missingNumber = findMissingNumber(arr)
        if(missingNumber != -1) {
            println("Missing Number using Binary Search : $missingNumber")
        } else {
            println("No missing number in the range")
        }
        var sum = getSum(n)
        // subtract sum of numbers with each number in array
        // to find missing number in the sequence.
        for (number in arr) {
            sum -= number
        }
        println("The missing number in sequence is $sum")
    }

    private fun findMissingNumber(arr: IntArray): Int {
        var low = 0
        var high = arr.size - 1
        while(low <= high) {
            val mid = low + (high - low) / 2
            if(mid + 1 != arr[mid] && arr[mid - 1] == mid) {
                return mid + 1
            } else if(mid + 1 == arr[mid]) {
                low = mid +1
            } else {
                high = mid - 1
            }

        }
        return -1
    }

    /// sum of n numbers formula : n*(n-1)/2
    private fun getSum(n: Int): Int {
        return n * (n - 1) / 2
    }

}