package programs.arrays


fun main() {
    val numRows = 5
    val output = generate(numRows)
    println(output)
}

fun generate(numRows: Int): List<List<Int>> {
    val list: MutableList<List<Int>> = ArrayList()
    var row: MutableList<Int>
    lateinit var pre: List<Int>
    for (i in 0 until numRows) {
        row = ArrayList()
        for (j in 0..i) {
            if (j == 0 || j == i) row.add(1) else row.add(pre[j - 1] + pre[j])
        }
        pre = row
        list.add(row)
    }
    return list
}
