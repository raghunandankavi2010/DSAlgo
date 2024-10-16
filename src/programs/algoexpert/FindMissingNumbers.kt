package programs.algoexpert

fun main() {
    val arr = mutableListOf(4, 6, 3)
    val result = missingMoreNumbers(arr)
    println("Missing more numbers: $result")

    val arr2 = mutableListOf(4, 5, 3)
    val result2 = missingNumbers(arr2)
    println("Missing two numbers: $result2")

    val arr3 = mutableListOf(4, 5, 3, 1)
    val result3 = missingOneNumber(arr3)
    println("Missing one number: $result3")
}

fun missingOneNumber(arr3: MutableList<Int>): Int {
    val n = arr3.size + 1
    var missing = (n *(n+1))/2
    arr3.forEach {
        missing -= it
    }
    return missing
}

fun missingNumbers(nums: MutableList<Int>): List<Int> {
   val set = HashSet<Int>()
    for( i in 1.. nums.size+2) {
        set.add(i)
    }
    nums.forEach {
        set.remove(it)
    }
    return set.toMutableList()
}


fun missingMoreNumbers(nums: MutableList<Int>): List<Int> {
    val set = HashSet<Int>()
    val maxElement = nums.maxOf { it }
    for( i in 1.. maxElement) {
        set.add(i)
    }
    nums.forEach {
        set.remove(it)
    }
    return set.toMutableList()
}
