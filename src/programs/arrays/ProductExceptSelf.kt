package programs.arrays

/**
 * Input: nums = [1,2,3,4]
 * 1. Calculate left product at position
 * left product = 1,1,2,6
 * rightProduct = 1
 * multiply by left product
 * 4 index -> 6 * 1
 * rightProduct *= 4 -> 4*1 = 4
 * 2*4 = 8  rightProduct = 4*3 = 12
 * 1*12 = 12 rightProduct = 12 * 2 = 24
 * 1*24 = 24 reached the end
 * Output: [24,12,8,6]
 *
 * */
fun main() {
    val nums = arrayOf(1,2,3,4)

    val outputArray = IntArray(nums.size) {0}
    outputArray[0] = 1

    for(i in 1 until nums.size) {
        outputArray[i] = outputArray[i-1] * nums[i-1]
    }

    var right = 1

    for(i in nums.size-1 downTo  0) {
        outputArray[i] = outputArray[i] * right
        right *= nums[i]
    }

    outputArray.forEachIndexed { index, num ->
        if(index == outputArray.size -1) {
            print("$num")
        } else {
            print("$num ")
        }
    }

}