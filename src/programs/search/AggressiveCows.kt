package programs.search

fun main() {
    val nums = intArrayOf(1, 2, 4, 8, 9)
    val k = 3
    print(aggressiveCows(nums,k))

}

fun aggressiveCows(nums: IntArray, cows: Int): Int {
    nums.sort()
    var low = 0
    var high = nums[nums.size-1] - nums[0]
    var res = 0

    while(low <= high) {
        val mid = low+(high-low)/2
         if(checkIfPossible(nums,cows,mid)) {
             res = mid
             low = mid + 1
         } else {
             high = mid - 1
         }
    }
    return res

}

fun checkIfPossible(nums: IntArray, cows: Int, dist: Int): Boolean {

    var prevStall = nums[0]
    var count = 1
     for( i in 1..<nums.size) {
         if(nums[i] - prevStall >= dist) {
             prevStall = nums[i]
             count++

         }
     }
    return (count >= cows)

}
