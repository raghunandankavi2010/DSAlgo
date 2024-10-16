package programs.search


fun main() {
    val array = intArrayOf(1,3,5,8,12,13,17,19,28,39,103,123,140,2040)
    val givenNumber = 17

    println(findIndex(array,givenNumber))

}

fun findIndex(array: IntArray, givenNumber: Int): Int {
    val jump = 3
    var l = 0
    var r = 3

    while(array[r] < givenNumber) {
        l = r
        r += jump
    }

    return binarySearchNow(array,givenNumber,l,r)
}

fun binarySearchNow(array: IntArray,givenNumber: Int, l: Int, r: Int): Int {

    if(l<=r) {
        val mid = l+(r-l)/2

        if(array[mid] == givenNumber) return mid
        return if(array[mid] > givenNumber) {
            binarySearchNow(array,givenNumber,l,mid-1)
        } else {
            binarySearchNow(array,givenNumber,mid+1,r)
        }
    } else{
        return -1
    }

}