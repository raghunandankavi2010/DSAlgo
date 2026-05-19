package programs.arrays


private fun getCommon(nums1: IntArray, nums2: IntArray): Int {

    var i = 0
    var j = 0

    while(i < nums1.size && j < nums2.size) {

        if(nums1[i] < nums2[j]) {
            i++
        } else if(nums2[j] < nums1[i]) {
            j++
        } else {
           return  nums1[i]
        }
    }
    return -1
}

fun main() {
    val nums1 = intArrayOf(1,2)
    val nums2 = intArrayOf(2,4)

    val commonMinNumber = getCommon(nums1, nums2)
    println(commonMinNumber)
}
