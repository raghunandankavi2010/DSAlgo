package programs.arrays

/**
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3]
 * Explanation: Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively. It doesn't matter what you leave beyond the returned length.
 */
class RemoveDuplicatesSortedArray {

    companion object {

        @JvmStatic
        fun main(array: Array<String>) {

            val arr = intArrayOf(1, 1, 1, 2, 2, 3)
            val value = removeDuplicates(arr)
            println(value)
        }

        private fun removeDuplicates(arr: IntArray): Int {
            val n = arr.size
            if(n<3){
                return n
            }
            var s = 2
            var f = 2
            while(f<n) {
                if(arr[f]!=arr[s-2]) {
                    arr[s++] = arr[f]
                }
                f++
            }
            return s
        }
    }
}