package programs.strings


/**
 * Aaditya
 * a - occurs 3
 * while D occurs only once
 * While comparing case is ignored but while printing
 * print original character
 */


fun main() {
        val input1 = "AaDitya"
        for (i in input1.indices) { //1
            var flag = false
            val first = input1[i] // a
            for (j in input1.indices) {
                if (i != j) { // if you are at second position D ignore comparing it with itself
                    val second = input1[j]
                    if (Character.toLowerCase(first) == Character.toLowerCase(second)) { // ignore case and compare
                        flag = true
                        break
                    }
                }
            }
            if (!flag) {
                println(first)
                break
            }
        }
}