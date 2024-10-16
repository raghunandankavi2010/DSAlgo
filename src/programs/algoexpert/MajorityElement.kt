package programs.algoexpert

fun main() {
    val list = mutableListOf(1,2,2,1,2)
    println(majorityElement(list))
}

private fun majorityElement(array: MutableList<Int>): Int {
    // Write your code here.
    var answer = array[0]
    var count = 1

    for(i in 1 until array.size) {

        if(array[i] == answer) {
            count++
        } else {
            count--
        }
        if(count < 0) {
            answer = array[i]
            count = 1
        }
    }

   if(count == 0) return -1
    return answer
}