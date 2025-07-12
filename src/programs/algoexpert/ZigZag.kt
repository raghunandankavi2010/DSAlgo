package programs.algoexpert

fun main() {

    val givenMatrix = listOf(
        listOf(1, 3, 4, 10),
        listOf(2, 5, 9, 11),
        listOf(6, 8, 12, 15),
        listOf(7, 13, 14, 16)
    )
    val output = zigzagTraverse(givenMatrix)
    println("Zig Zag Traversal of a matrix")
    println(output)
}

private fun zigzagTraverse(array: List<List<Int>>): List<Int> {
    var goingDown = true
    val height = array.size - 1
    val width = array[0].size - 1
    val result = mutableListOf<Int>()

    var row = 0
    var col = 0

    while(!isOutOfBounds(row,col,height,width)) {
        result.add(array[row][col])
        if(goingDown) {
            if(col == 0 || row == height) {
                goingDown = false
                if(row == height) {
                    col++
                } else {
                    row++
                }
            } else {
                row++
                col--
            }
        } else {
            if( col == width || row == 0) {
                goingDown = true
                if(col == width) {
                    row++
                } else {
                    col++
                }
            } else {
                row--
                col++
            }
        }

    }

    return result
}


private fun isOutOfBounds(row: Int, col: Int, height: Int, width: Int) =
    row < 0 || row > height || col < 0 || col > width
