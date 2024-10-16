package programs.arrays

/*
Given an integer array nums of unique elements, return all possible
subsets
(the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]*/
fun main() {

    val input =arrayOf<Int>(1,2,3)
    val list = ArrayList<ArrayList<Int>>()
    backtrack(list,ArrayList<Int>(),input,0)
    println(list)
}

private fun backtrack(list: ArrayList<ArrayList<Int>>, temp: ArrayList<Int>, nums: Array<Int>, start: Int) {
    list.add(ArrayList(temp)) // add empty initially
    for(i in start until nums.size) { //loop through the elements
        temp.add(nums[i]) // add to the temp list
        backtrack(list,temp,nums,i+1) // while backtracking increment the index
        temp.removeAt(temp.size-1) // since its already added while backtracking remove from the temp list
    }
}
