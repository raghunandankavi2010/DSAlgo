package programs.arrays

import java.util.*

fun main() {
    val arr = intArrayOf(0,0,0)
    println(threeSum(arr))
}


fun threeSum(nums: IntArray): List<List<Int>> {
    nums.sort()
    val listOfList = ArrayList<List<Int>>()
    for( i in nums.indices) {
        if(i > 0 && nums[i] == nums[i-1]) continue
        val firstNumber = nums[i]
        val target = 0 - nums[i]
        var left = i + 1
        var right = nums.size - 1
        while(left < right) {
            val sum = nums[left] + nums[right]
            if(sum == target) {
                val list = ArrayList<Int>()
                list.add(nums[left])
                list.add(nums[right])
                list.add(nums[i])
                listOfList.add(list)
                while(left < right && nums[left] == nums[left + 1] ) {
                    left++
                }
                while(right > left && nums[right] == nums[right - 1]) {
                    right--
                }
                right--
                left++
            } else if(sum > target) {
                right--
            } else {
                left--
            }
        }
    }

    return listOfList

}