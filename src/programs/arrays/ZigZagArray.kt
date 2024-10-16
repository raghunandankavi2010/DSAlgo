package programs.arrays

/**
 * Input: N = 7 , arr[] = {4, 3, 7, 8, 6, 2, 1}
 * Output: arr[] = {3, 7, 4, 8, 2, 6, 1}
 */
fun main() {
    val input = arrayOf(1,2,3)
    val output = zigzag(input)
    output.forEach {
        print("$it ")

    }
}

fun zigzag(arr: Array<Int>): Array<Int> {
    var flag = true
    var i = 0
    val n = arr.size-1
    while(i < n) {
        // if flag is true arr[i] < arr[i+1] else swap < condition
        if(flag && arr[i] > arr[i+1]) {
           val temp = arr[i]
            arr[i] = arr[i+1]
            arr[i+1] = temp
        } else if(!flag && arr[i] < arr[i+1]) { // if flag is true arr[i] < arr[i+1] else swap < condition
            val temp = arr[i]
            arr[i] = arr[i+1]
            arr[i+1] = temp
        }
        flag = !flag
        i++
    }

    return arr
}

