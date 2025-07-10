package programs.algoexpert

import kotlin.math.abs
import kotlin.math.min


fun main() {
    val blocks = listOf(
        mapOf("gym" to false, "school" to true, "store" to false),
        mapOf("gym" to true, "school" to false, "store" to false),
        mapOf("gym" to true, "school" to true, "store" to false),
        mapOf("gym" to false, "school" to false, "store" to false),
        mapOf("gym" to false, "school" to false, "store" to true)
    )

    val reqs = listOf("gym", "school", "store")

    val optimalIndex = apartmentHunting(blocks, reqs)

    println(optimalIndex)
}

private fun apartmentHunting(blocks: List<Map<String,Boolean>>, reqs: List<String>): Int {
    if(blocks.isEmpty() || reqs.isEmpty()) return -1

    val minDistances  = mutableMapOf<String, List<Int>>()

    for(req in reqs) {
        val distances = MutableList(blocks.size) { Int.MAX_VALUE }

        var lastSeenAt = Integer.MAX_VALUE
        for (i in blocks.indices) {
            if (blocks[i][req] == true) {
                lastSeenAt = i
            }
            distances[i] = min(distances[i],abs(i - lastSeenAt))
        }

        lastSeenAt = Integer.MAX_VALUE

        for(i in blocks.size-1 downTo 0) {

            if(blocks[i][req] == true) {
                lastSeenAt = i
            }

            distances[i] = min(distances[i], abs(i - lastSeenAt))
        }
        minDistances[req] = distances
    }


    val numBlocks = blocks.size
    val maxDistancesPerBlock = (0 until numBlocks).map { blockIndex ->
        minDistances.values.maxOf { distances -> distances[blockIndex] }
    }

    return maxDistancesPerBlock
        .withIndex()
        .minByOrNull { it.value }
        ?.index ?: -1
}