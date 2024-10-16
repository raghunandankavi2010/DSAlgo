package programs.algoexpert


//fun zeroSumSubarray(arr: IntArray): Boolean {
//    val sumSet = mutableSetOf<Int>()
//    var sum = 0
//
//    for (num in arr) {
//        sum += num
//
//        if (sum == 0 || sumSet.contains(sum)) {
//            return true
//        }
//
//        sumSet.add(sum)
//    }
//
//    return false
//}
//
//fun main() {
//    val arr = intArrayOf(-5,-5,2,3)
//    val result = zeroSumSubarray(arr)
//    println(result)
//}

// for non continous subarray sum zero
fun main() {
    val nums = mutableListOf(-5,-5,3,2,-2)
    println(zeroSumSubarray(nums))
}

fun zeroSumSubarray(nums: List<Int>): Boolean {
    val map = HashMap<Pair<Int, Int>, Boolean>()
    return backtracking(nums, 1, nums[0], map)
}

fun backtracking(nums: List<Int>, index: Int, currSum: Int, map: HashMap<Pair<Int, Int>, Boolean>): Boolean {
    if (currSum == 0 && index > 0) return true
    if (index == nums.size) return false

    val key = Pair(index, currSum)
    if (map.containsKey(key)) {
        return map[key]!!
    }

    val included = backtracking(nums, index + 1, currSum + nums[index], map)
    if (included) {
        map[key] = true
        return true
    }

    val excluded = backtracking(nums, index + 1, currSum, map)
    if (excluded) {
        map[key] = true
        return true
    }

    map[key] = false
    return false
}
