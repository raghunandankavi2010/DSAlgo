package programs.algoexpert

private fun isMonotonic(nums: List<Int>): Boolean {
    var increasing = true
    var decreasing = true

    for (i in 1 until nums.size) {
        if (nums[i] > nums[i - 1]) decreasing = false
        if (nums[i] < nums[i - 1]) increasing = false
    }

    return increasing || decreasing
}

fun main() {
    val testCases = listOf(
        listOf(1, 2, 2, 3),     // true
        listOf(6, 5, 4, 4),     // true
        listOf(1, 3, 2),        // false
        listOf(1),              // true
        emptyList(),      // true
        listOf(3, 3, 3),        // true
        listOf(1, 2, 3, 2),     // false
    )

    for (test in testCases) {
        println("Input: $test → Monotonic: ${isMonotonic(test)}")
    }
}