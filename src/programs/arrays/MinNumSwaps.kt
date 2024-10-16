package programs.arrays

/**
 *  Minimum number of swaps to group all ones together
 */
fun main() {
    val arr = arrayOf(1,0,1,0,1,0,1,1,1)

    // calculate total number of ones. that will be our window
    val totalOnes = arr.count { it == 1}
    var currZeros = 0
    var ans: Int

    // calculate the number of zeros in the first window
    for(i in 0 until totalOnes) {
        if(arr[i] == 0) {
            currZeros += 1
        }
    }
    ans = currZeros

    // calculate number of zeros in from 2nd window to last
    // if the window size exceeds remove the first item by doing minus 1
    // update the ans
    for(i in totalOnes until arr.size) {
        if(arr[i] == 0) {
            currZeros += 1
        }
        if (arr[i - totalOnes] == 0)
            currZeros -= 1
        ans = ans.coerceAtMost(currZeros)
    }

    println(ans)

}

