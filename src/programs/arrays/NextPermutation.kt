package programs.arrays


fun main() {
    nextPermutation(intArrayOf(1,3,2))
}

//[1,1,5]
fun nextPermutation(nums: IntArray) {

    val originalArray = nums
    var index = -1
    for (i in (nums.size - 1) downTo 0) {
        if (i > 0 && nums[i] > nums[i - 1]) {
            index = i
            break
        }
    }
    if (index > 0) {
        index --
        var toSwap = -1
        for (i in index until nums.size) {
            if (nums[i] > nums[index]) {
                toSwap = i
            }
        }
        swapArray(nums, 0 + index, toSwap)
        var start = index + 1
        var end = nums.size - 1
        while (start < end) {
            val temp = nums[start]
            nums[start] = nums[end]
            nums[end] = temp
            start++
            end--
        }
    } else {
        nums.sort()
    }
    nums.forEach {
        println(it)
    }
}

fun swapArray(arr: IntArray, i: Int, j: Int) {
    val t = arr[i]
    arr[i] = arr[j]
    arr[j] = t
}