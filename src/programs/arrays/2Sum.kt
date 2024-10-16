package programs.arrays

/**
 * Input: nums = [2,7,11,15], target = 9
 */
fun main() {
    val arr = arrayOf(2, 7, 11, 15, 2)
    val target = 9
    val output = Array(2){0}

    val map = HashMap<Int,Int>()
    arr.forEachIndexed { index, it ->
        val x = it
        val y = target - it
        if ((map.containsKey(y))) {
            output[1] = index
            output[0] = map.getOrDefault(y,1)
            println("$x $y")
        } else if (!map.containsKey(it)) {
            map.put(it,index)
        }
    }

    println("${output[0]} ${output[1]}")
}