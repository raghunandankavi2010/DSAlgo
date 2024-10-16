package programs.strings

/**
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.



Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"


Constraints:

1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
fun main() {
    val num1 = "0"
    val num2 = "0"
    println(multiply(num1,num2))
}
fun multiply(num1: String, num2: String): String {

    val res = Array(num1.length + num2.length) { 0 }
    for(i in num1.length-1 downTo 0 ){

        for(j in num2.length-1 downTo 0 ){
            val mul = (num1[i] - '0') * (num2[j] - '0')

            val sum = res[i + j + 1] + mul // add previous element at position + product
            res[i +j] += sum /10 // add carry to previous position
            res[ i + j + 1] = sum %10 // update last digit in result array
        }
    }

    val stringBuilder = StringBuilder()
    res.forEach {
        if(it != 0 || stringBuilder.isNotEmpty()) {
            stringBuilder.append(it)
        }
    }

    return  if(stringBuilder.isEmpty()) {
        "0"
    } else {
        stringBuilder.toString()
    }
}
