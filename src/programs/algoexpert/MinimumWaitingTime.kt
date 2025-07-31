package programs.algoexpert

fun main() {
    val input = mutableListOf(3,2)
    val output = minimumWaitingTime(input)
    print(output)
}
// 1,  2  ,2,     3,         6
// 0   1    1+2   1+2+2     1+2+2+3
 //0   1     3     5          8
private fun minimumWaitingTime(queries: MutableList<Int>): Int {
    // Write your code here.
    if(queries.size == 1) return 0
    queries.sort()
    var count = 0
    var newCount = 0
    for( i in 1.. queries.size -1) {
        count = count + queries[i-1]
        newCount = newCount + count

    }

    return newCount
}
