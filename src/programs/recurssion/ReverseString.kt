package programs.recurssion


fun main() {
    val input = "R"
    val output = reverseString(input)
    println("Reversed String using recursion $output")
}

private fun reverseString(input: String): String {
    if(input.isEmpty()) return ""
   return  reverseInputString(input,input.length -1,"")
}

private fun reverseInputString(input: String, index: Int,  reversed: String): String {
    if(index < 0) return reversed
    val revString= reversed + input[index]

    return reverseInputString(input.take(index),index-1,revString)
}
