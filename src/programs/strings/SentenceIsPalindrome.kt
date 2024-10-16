package programs.strings

fun main() {
    val s = "Abc def ghi jklm."
    val ch = s.toCharArray()
    var i = 0
    var j = s.length -1
    var isPalindrome = true
    while (i < s.length - 1) {

        if(!Character.isLetterOrDigit(ch[i]) && !Character.isLetterOrDigit(ch[j]) && Character.toLowerCase(ch[i]) == Character.toLowerCase(ch[j]) ){
            i++
            j--
        } else if(Character.isLetterOrDigit(ch[i])){
            i++
        } else if(Character.isLetterOrDigit(ch[j])) {
            j--
        } else {
            isPalindrome = false
            break
        }
    }
    if(isPalindrome) {
        println("Palindrome")
    } else {
        println("Not palindrome")
    }
}