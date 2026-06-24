package programs.arrays


private fun nextGreaterElement(nums: IntArray): IntArray {
    val n = nums.size
    val res = IntArray(n)
    // This stack will store actual values, not indices
    val stack = ArrayDeque<Int>()

    // Process from right to left
    for (i in n - 1 downTo 0) {
        // 1. Clear out elements that are smaller than or equal to the current number
        while (stack.isNotEmpty() && stack.last() <= nums[i]) {
            stack.removeLast()
        }

        // 2. The element on top is now the next greater element
        res[i] = if (stack.isNotEmpty()) stack.last() else -1

        // 3. Push the current number onto the stack for elements to the left to see
        stack.addLast(nums[i])
    }

    return res
}

/**
 *   Tracing for input 2, 1 , 1, 4 , 3
 *     /***                    i =  4
 *      *  input = 2,  1 ,  2, 4, 3
 *      *  stack is empty. so put -1 in res at the last index
 *      *
 *      *  res =  0 , 0 , 0 , 0, -1
 *      *  add 3 to stack
 *      *
 *      *  stack  -> 3
 *      *
 *      *  i = 3 , nums[i] = 4
 *      *
 *      *  3 <= 4 true -> remove 3
 *      *  stack is empty put -1 a tindex 3
 *      *  res = 0 ,0 ,0, -1, -1
 *      *  put 4 in stack
 *      *
 *      *  stack -> 4
 *      *
 *      *  index i = 2
 *      *  nums[2] = 2
 *      *
 *      *  4 < = 2 false
 *      *
 *      *  add 4 to result at index  2
 *      *
 *      *  res = 0, 0 ,4, -1, -1
 *      *  stack still has 4
 *      *  add 2 to stack
 *      *
 *      *  stack now is 4,2
 *      *  index  i = 1 , nums[i] = 1
 *      *
 *      *  2 <= 1 false
 *      *
 *      *  add 2 to result ar index i  =1
 *      *
 *      *  res = 0, 2 ,4, -1, -1
 *      *
 *      *  Now index i = 0, nums[i] = 2
 *      *
 *      *  2 <= 2 true
 *      *  pop 2 from stack
 *      *
 *      *  stack has 4
 *      *  4<=2 false no pop
 *      *  add 4 to res ad index 0
 *      *  res =  4,2,4,-1,-1
 *      *
 *      */
 *
 *
 */
fun main() {
    // Test Case 1: Standard mixed array
    val testInput1 = intArrayOf(2, 1, 2, 4, 3)
    val result1 = nextGreaterElement(testInput1)
    println("Input:  ${testInput1.contentToString()}")
    println("Output: ${result1.contentToString()}")
    // Expected Output: [4, 2, 4, -1, -1]
    //Tracing


    println("---")

    // Test Case 2: Strictly decreasing array (Worst case for stack size, best case for time)
    val testInput2 = intArrayOf(5, 4, 3, 2, 1)
    val result2 = nextGreaterElement(testInput2)
    println("Input:  ${testInput2.contentToString()}")
    println("Output: ${result2.contentToString()}")
    // Expected Output: [-1, -1, -1, -1, -1]
}