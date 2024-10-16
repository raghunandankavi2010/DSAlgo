package programs.others

/**
 * Given positive integers start and end (start < end), return the minimum number of operations needed to convert start to end using these operations:

Increment by 1
Multiply by 2
Constraints

start < end < 2 ** 31
Example 1
Input
start = 2
end = 9
Output
3
Explanation
We can multiply 2 to get 4, and then again to get 8, then add 1 to get 9.
 */

fun main() {
    val start = 4
    var end = 10
    var result: Int
    var count = 0

    while(end != start) {
        if(end % 2 != 0) {
            end -= 1
        } else {
            result = end / 2
            if( result < start) {
                count =  count + end - start
                break
            }
            end = result
        }
        count++
    }
    println(count)
}