package programs.others

/**
 *  initially i thought of adding 1 to number
 *  and checking it if its palindrome or not.
 *  But the above approach is not good.
 *  Below approach is based on finding middle element
 *  and mirroring left half to the right half
 *  case where left side element of mid is less than right side
 *  add 1 to middle and carry to left side and mirror that on right
 *  in case left and right half of middle is already a palindrome the
 *  add 1 to the middle element
 *
 */
fun main() {
    val num = intArrayOf(9, 9, 9)
    if (isAll9(num, num.size)) {
        print("1")
        for (i in 0 until num.size - 1) print("0")
        println("1")
    } else {
        getNextPalindrome(num, num.size)
    }

}

private fun isAll9(num: IntArray, n: Int): Boolean {
    for (i in 0 until n) if (num[i] != 9) return false
    return true
}

private fun getNextPalindrome(num: IntArray, size: Int) {
    val mid = num.size / 2

    var i = mid - 1
    var j = if (size % 2 == 0) mid else mid + 1

    while (i >= 0 && num[i] == num[j]) {
        i--
        j++
    }
    var leftsmaller = false
    if (i < 0 || num[i] < num[j])
        leftsmaller = true

    while (i >= 0) {
        num[j++] = num[i--]
    }

    if (leftsmaller) {
        var carry = 1
        if (size % 2 == 1) {
            num[mid] = num[mid] + 1
            carry = num[mid] / 10
            num[mid] = num[mid] % 10
        }

        i = mid - 1
        j = if (size % 2 == 0) mid else mid + 1

        while (i >= 0 && carry > 0) {
            num[i] = num[i] + carry
            carry = num[i] / 10
            num[i] = num[i] % 10
            num[j] = num[i]
            i--
            j++
        }
    }
    printArray(num)

}

private fun printArray(num: IntArray) {
    for (i in num.indices) print(num[i])
    println()
}