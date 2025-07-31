package programs.algoexpert

class ThreeLargestNumbers {

    fun findThreeLargestNumbers(list: List<Int>): List<Int> {

        val result = mutableListOf<Int>()

        var first = Int.MIN_VALUE
        var second = Int.MIN_VALUE
        var third = Int.MIN_VALUE

        for (i in 0 until 3) {
            val element = list[i]
            if (element >= first) {
                third = second
                second = first
                first = element
            } else if (element >= second) {
                third = second
                second = element
            } else if (element >= third) {
                third = element
            }
        }
        for (i in 3 until list.size) {
            val element = list[i]
            if (element >= first) {
                third = second
                second = first
                first = element
            } else if (element >= second) {
                third = second
                second = element
            } else if (element >= third) {
                third = element
            }
        }

        result.add(third)
        result.add(second)
        result.add(first)

        return result
    }

}

fun main() {

    val list = listOf(55, 7, 8)
    val threeLargestNumbers = ThreeLargestNumbers()
    val output = threeLargestNumbers.findThreeLargestNumbers(list)
    print(output)
}