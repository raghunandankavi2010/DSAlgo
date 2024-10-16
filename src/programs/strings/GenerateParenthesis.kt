package programs.strings



fun main() {
    val ans = ArrayList<String>()
    val currentString = ""
    combination(ans,currentString, 0, 0, 3)
    println(ans)
}


fun combination(
    ans: ArrayList<String>,
    currentString: String,
    openCount: Int,
    closeCount: Int,
    n: Int
) {

    if (currentString.length == n * 2) {
        ans.add(currentString)
        return
    }

    if (openCount < n) {
        combination(ans, "$currentString(", openCount + 1, closeCount, n)
    }
    if (closeCount < openCount) {
        combination(ans, "$currentString)", openCount, closeCount + 1, n)
    }
}
