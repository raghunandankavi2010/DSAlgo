package programs.algoexpert

fun main() {

    val input = arrayOf(-10, -10, -9, -7, -7, -6, -5, -2, 2, 2, 3, 3, 4, 5, 8, 8, 9, 10)
    bubbleSort(input)
}

private fun bubbleSort(arr : Array<Int>) {

    val n = arr.size-1
    for(i in 0.. n) {
        for(j in 0.. n-i-1) {
            if(arr[j] > arr[j+1]){
                val temp = arr[j]
                arr[j] = arr[j+1]
                arr[j+1] = temp
            }
        }
    }
    val output = arr.joinToString(",")
    print(output)
}