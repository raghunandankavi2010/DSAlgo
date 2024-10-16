package programs.strings

/**
 *  Longest common subsequence.
 */

fun main() {

    val str1 = "AGGTAB"
    val str2  = "GXTXAYB"
    val result: Int = lcsDynamic(str1.toCharArray(), str2.toCharArray())
}

fun lcsDynamic(str1: CharArray, str2: CharArray): Int {
    val temp = Array(str1.size + 1) { IntArray(str2.size + 1) }
    var max = 0
    for (i in 1 until temp.size) {
        for (j in 1 until temp[i].size) {
            if (str1[i - 1] == str2[j - 1]) {
                temp[i][j] = temp[i - 1][j - 1] + 1
            } else {
                temp[i][j] = kotlin.math.max(temp[i][j - 1], temp[i - 1][j])
            }
            if (temp[i][j] > max) {
                max = temp[i][j]
            }
        }
    }

    // Tracing part
    var index = temp[str1.size][str2.size]
    val tempIndex = index
    var m = str1.size
    var n = str2.size
    val lcsArray = CharArray(tempIndex + 1)
    lcsArray[tempIndex] = 0.toChar()

    while(m > 0 && n > 0) {
        if(str1[m -1] == str2[n -1]) { // if char starting from last are same
            lcsArray[index-1] = str1[m-1] // copy that to temp array and decrement indexes
            m--
            n--
            index --
        } else if(temp[m-1] [n] > temp[m] [n-1]) { // if value of char of s1 is greater than s2 decrement left index
            m--
        } else {
            n--
        }
    }
    // print the temp array
    for (k in 0 until tempIndex) print(lcsArray[k])

    return max
}


