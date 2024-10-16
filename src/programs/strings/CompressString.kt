package programs.strings

fun main() {
    println("Compressed String ${compress("aaabbc")}")
}

fun compress(s: String): String {
    if(s.isEmpty()) return ""
    var count = 1
    var prevChar = s[0]
    val sb = StringBuilder()
    for(i in 1 until s.length) {
        if(s[i] == prevChar){
            count ++
        } else {
            sb.append("${prevChar}$count")
            prevChar = s[i]
            count = 1
        }
    }
    sb.append("${prevChar}$count")
    return sb.toString()
}