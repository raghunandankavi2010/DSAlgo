package programs.arrays

/* Peak element in array
   A peak element is a element that is greater than its neighbours
*
* */
fun main() {
    val nums = arrayOf(1,2,3,1)
    peakElement(nums)
}

fun peakElement(arr: Array<Int>) {
    val n = arr.size
    if(n == 1){
        println(arr[0])
    } else if(n == 2 && arr[0] > arr[1]) {
        println(arr[0])
    } else if(arr[n-1] >= arr[n-2]){
        println(arr[n-1])
    }

    for( i in arr.indices){
        if(i-1 >= 0 && i+1 <= arr.size-1) {
            if(arr[i] > arr[i-1] && arr[i+1] < arr[i]) {
                println(arr[i-1])
            } else{
                continue
            }
        }
    }

}
