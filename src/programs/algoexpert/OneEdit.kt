package programs.algoexpert

import kotlin.math.abs


fun main() {
    val str1 = "abcdefghijklmnopqrstuvwxyz"
    val str2 = "abcdefghijklmnopqrstuvwxyz"

    val output = oneEdit(str1, str2)
    println(output)
}

private fun oneEdit(stringOne: String, stringTwo: String): Boolean {
    // Write your code here.

    if(stringOne == stringTwo) return true
    val len1 = stringOne.length
    val len2 = stringTwo.length

    val diffLength = abs(stringOne.length - stringTwo.length)

    if(diffLength > 1) return false

    var count = 0

    if(diffLength == 0) {
        for(i in 0 .. stringOne.length -1 ) {
            if(stringOne[i] != stringTwo[i])  {
                count++
            }
        }
        return if(count == 1) {
            true
        } else {
            false
        }
    }

    if(stringOne.isEmpty() && stringTwo.length ==1 ) return true


    if(stringTwo.isEmpty() && stringOne.length ==1 ) return true

    val shorter = if (len1 < len2) stringOne else stringTwo
    val longer = if (len1 < len2) stringTwo else stringOne

    var i = 0
    var j = 0
    var editUsed = false

    while (i < shorter.length && j < longer.length) {
        if (shorter[i] != longer[j]) {
            if (editUsed) {
                return false
            }
            editUsed = true
            j++
        } else {
            i++
            j++
        }
    }

    return true
}
