package programs.arrays

fun main() {

    val arr = intArrayOf(12, 35, 1, 10, 34, 1)
    val secondLargest = findSecondLargest(arr)
    println(secondLargest)
    println("By Sorting")
    println(findSecondLargestBySSorting(arr))
}

fun findSecondLargestBySSorting(arr: IntArray): Int {

    arr.sort()
    return arr[arr.size - 2]
}

fun findSecondLargest(arr: IntArray): Int {

    var first = arr[0]
    var second = arr[0]

    for (i in 1 until arr.size) {
        if (arr[i] > first) {
            second = first
            first = arr[i]
        } else if (arr[i] > second && arr[i] != first) {
            second = arr[i]
        }
    }
    return second
}
