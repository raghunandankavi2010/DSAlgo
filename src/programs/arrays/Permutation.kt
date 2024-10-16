package programs.arrays

fun main() {
    val nums = arrayOf(1, 2, 3)
    val list = ArrayList<ArrayList<Int>>()
    permutation(list, ArrayList(), nums)
    list.forEach {
        println(it)
    }

}


private fun permutation(list: ArrayList<ArrayList<Int>>, tempList: ArrayList<Int>, nums: Array<Int>) {
    if (tempList.size == nums.size) {
        list.add(ArrayList(tempList))
        return
    }
    for (i in nums.indices) {
        if (tempList.contains(nums[i])) continue
        tempList.add(nums[i])
        permutation(list, tempList, nums)
        tempList.removeAt(tempList.size - 1)
    }
}
