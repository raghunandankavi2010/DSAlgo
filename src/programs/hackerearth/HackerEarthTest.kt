package programs.hackerearth

/**
 * Find the start index and end index in such a way,
 * that sorting the sub array will result in entire array sorted
 */
fun main() {
    val arr = intArrayOf(10, 12, 40, 35, 5, 50, 60)
    printUnsorted(arr)
}

fun printUnsorted(arr: IntArray) {
    var start = 0
    var end = 0

    for(i in arr.indices){
        if(arr[i]> arr[i+1]){
            start = i
            break
        }
    }

    if (start == arr.size-1) {
        return
    }

    for(i in arr.size-1 downTo 0) {
        if(arr[i] < arr[i-1]) {
            end = i
            break
        }
    }

    var min = arr[start]
    var max = arr[start]

    for(i in  (start + 1).. end) {
        if(arr[i] > max)
            max = arr[i]
        if(arr[i] < min)
            min = arr[i]
    }

    println("$min and $max")

    for( i in 0.. start){
        if(arr[i] > min) {
            start = i
            break
        }
    }

    for( i in arr.size-1 downTo (end+1)){
        if(arr[i] < max) {
            end = i
            break
        }
    }

    println("$start and $end")
}
