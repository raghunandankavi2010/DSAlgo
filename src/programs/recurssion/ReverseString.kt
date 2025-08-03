package programs.recurssion


fun main() {
    val input = "Hello"
    val s = input.toCharArray()
    val output = reverseString(input)
    println("Reversed String using recursion2 $output")
    helper(s, 0, input.length - 1)
    println("Reversed String using recursion2 $output")
    println(s)
}

private fun reverseString(input: String): String {
    if(input.isEmpty()) return ""
   return  reverseInputString(input,input.length -1,"")
}

private fun reverseInputString(input: String, index: Int,  reversed: String): String {
    if(index < 0) return reversed
    val revString = reversed + input[index]

    return reverseInputString(input.take(index),index-1,revString)
}


private fun helper(s: CharArray, left: Int, right: Int) {

    if(left > right) {
        return
    }

    val temp = s[left]
    s[left] = s[right]
    s[right] = temp

    helper(s,left +1, right -1)

}