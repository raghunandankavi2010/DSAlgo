package programs.arrays

fun main() {
    val arr = intArrayOf(-1, 2, 1, -4)
    val target = 1
    println(threeSumClosest(arr,target))
}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    var ans = nums[0] + nums[1] + nums[nums.size-1]
    nums.sort()
    var diff = Integer.MAX_VALUE
    for( i in nums.indices) {
        val firstNumber = nums[i]
        var left = i + 1
        var right = nums.size - 1
        while(left <  right) {
            val sum = nums[left] + nums[right] + firstNumber
            if(sum > target) {
                right--
            } else {
                left++
            }
            if(Math.abs(sum - target )< Math.abs(ans - target)) {
                ans = sum
            }
        }

    }
    return ans
}