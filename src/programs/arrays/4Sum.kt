package programs.arrays


import java.util.*

data class Quadrets(val first: Int, val second: Int, val third: Int, val fourth: Int)

fun main() {
    val inputArray = intArrayOf(1, 0, -1, 0, -2, 2)
    val target = 2

    Arrays.sort(inputArray)

    val set = HashSet<Quadrets>()

    for (i in inputArray.indices) {
        for (j in i + 1 until inputArray.size) {
            var start = j + 1
            var end = inputArray.size - 1
            while (start < end) {
                val sum = inputArray[i] + inputArray[j] + inputArray[start] + inputArray[end]
                if (sum == target) {
                    val quadrets = Quadrets(inputArray[i], inputArray[j], inputArray[start], inputArray[end])
                    if (!set.contains(quadrets)) {
                        set.add(quadrets)
                    }
                    start++
                    end--

                } else if (sum > target) {
                    end--
                } else {
                    start++
                }
            }
        }
    }

    set.forEach { quadret ->
        println("${quadret.first} ${quadret.second} ${quadret.third} ${quadret.fourth} ")
        
    }
}