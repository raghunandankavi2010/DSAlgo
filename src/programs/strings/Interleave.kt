package programs.strings

/**
 *  Given two String a and b interleave the string to create a new String
 *  a = abc
 *  b. def
 *  output = adbecf
 *
 */

fun main() {
    val a = "ab"
    val b = "def"
    val result = interleave(a, b)
    println(result)
}

fun interleave(a: String, b: String): String {
    val sb = StringBuilder()
        var i = 0
        while (i < a.length or b.length) {
            if(i < a.length) {
                sb.append(a[i])
            }
            if(i < b.length) {
                sb.append(b[i])
            }
            i++
        }

    return sb.toString()
}
