package programs.leetcode


fun main() {
    val input = intArrayOf(1, 1, 2)
    val output = permuteUnique(input)
    println(output)

}

private fun permuteUnique(nums: IntArray): List<List<Int>> {
    val result = ArrayList<MutableList<Int>>()
    nums.sort()
    val used = BooleanArray(nums.size)
    permHelper(mutableListOf(), nums, result, used)
    return result
}

private fun permHelper(
    tempList: MutableList<Int>,
    nums: IntArray,
    result: ArrayList<MutableList<Int>>,
    used: BooleanArray
) {
    if(tempList.size == nums.size) {
        result.add(ArrayList(tempList))
        return
    }

    for(i in 0.. nums.size-1) {
        if(used[i]) {
            continue
        }
        if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) {
            continue
        }
        tempList.add(nums[i])
        used[i] = true
        permHelper(tempList, nums, result, used)
        used[i] = false
        tempList.removeAt(tempList.size-1)
    }
}
