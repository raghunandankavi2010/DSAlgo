package programs.leetcode

fun main() {
    val array = intArrayOf(1,5,1,1,6,4)
    wiggleSort(array)
}


fun wiggleSort(nums: IntArray): Unit {

    val sortedArray = nums.sortedArray()
    val n = nums.size

    var left = (n-1)/2
    var right = nums.size - 1

    for(i in 0..<n){
        if(i%2 ==0 ) {
            nums[i] = sortedArray[left]
            left--
        } else {
            nums[i] = sortedArray[right]
            right--
        }
    }

    println(nums.joinToString(" "))

}