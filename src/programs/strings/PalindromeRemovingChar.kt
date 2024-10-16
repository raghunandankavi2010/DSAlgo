package programs.strings

object PalindromeRemovingChar {
    @JvmStatic
    fun main(args: Array<String>) {
        val str = "Mad"
        val isPalindrome = isPalin(str)
        println("$str is Palindrome? $isPalindrome")
        val index = possiblePalinByRemovingOneChar(str)
        println(index)
    }

    private fun isPalin(inputString: String): Boolean {
        val set = HashSet<Char>()
        inputString.forEach {
            if(set.contains(it)){
                set.remove(it)
            } else{
                set.add(it)
            }
        }
        return set.size<=1 // is palindrome if there is 1 element or less left
    }

    private fun possiblePalinByRemovingOneChar(str: String): Int {
        var low = 0
        var high = str.length - 1
        while (low <= high) {
            if (str[low] == str[high]) {
                low++
                high--
            } else {
                // check if removing the left char forms a palindrome
                if (isPalindrome(low + 1, high, str)) {
                    return low
                }

                // check if removing the right char forms a palindrome
                else if (isPalindrome(low, high - 1, str)) {
                    return high
                } else { // handle case when removing from left or right does not make string palindrome
                    low++
                    high--
                }
            }
        }
        return -1
    }

    private fun isPalindrome(mLow: Int, mHigh: Int, str: String): Boolean {
        var low = mLow
        var high = mHigh
        var check = false
        while (low < high) {
            check = if (str[low] == str[high]) {
                low++
                high--
                true
            } else {
                return false
            }
        }
        return check
    }
}