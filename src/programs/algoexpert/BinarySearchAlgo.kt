package programs.algoexpert

fun main() {
    val arr = intArrayOf(0, 1, 21, 33, 45, 61, 71, 72, 73)
    val target = -1
    val output = binarySearch(arr,0, arr.size-1, target)
    println("Target $target found at index $output")

}

private fun binarySearch(arr: IntArray, start: Int, end: Int, target: Int): Int {
    if(arr.isEmpty()) return -1
    if(start > end) return -1

    val mid = start + (end - start) / 2

    return if(arr[mid] == target) {
        mid
    } else if(target > arr[mid]) {
        binarySearch(arr,mid+1,end, target)
    } else {
        binarySearch(arr,start,mid-1, target)
    }
}