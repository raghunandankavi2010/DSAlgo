package programs.sorting

/**
 * Merge two sorted arrays
 */
fun main(){
    val arr1 = intArrayOf(1, 3, 5, 7)
    val n1 = arr1.size

    val arr2 = intArrayOf(2, 4, 6, 8)
    val n2 = arr2.size

    val arr3 = IntArray(n1+n2)

    mergeSort(arr1,arr2,n1,n2,arr3)
    printArrayElements(arr3)
}

fun printArrayElements(arr3: IntArray) {

    arr3.forEach {
        println(it)
    }
}

fun mergeSort(arr1: IntArray, arr2: IntArray, n1: Int, n2: Int, arr3: IntArray) {
    var i = 0
    var j = 0
    var k = 0
    while(i < n1 && j< n2){
        if(arr1[i]<arr2[j]){
            arr3[k] = arr1[i]
            k++
            i++
        } else {
            arr3[k] = arr2[j]
            k++
            j++
        }
    }

    while(i<n1){
        arr3[k] = arr1[i]
        k++
        i++
    }

    while(j<n2){
        arr3[k] = arr2[j]
        k++
        j++
    }

}
