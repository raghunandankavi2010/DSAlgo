package programs.backtracking

fun main() {
    val input = "23434343"
    val result = mutableListOf<String>()
    println(permute("", input, result))
}

fun permute(permute: String, input: String, result: MutableList<String>): MutableList<String> {
    if (permute.length == 3) {
        result.add(permute)
    }
    for (i in 0..input.length - 1) {
        permute(permute + input[i], input.substring(0, i) + input.substring(i + 1), result)
    }
    return result

}


