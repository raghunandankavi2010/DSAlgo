package programs.arrays

import kotlin.math.max

fun main() {
    val input = intArrayOf(8,1,5,2,6)
    val output = maxScoreSightseeingPair(input)
    println(output)
}

/*
 * You are given an integer array values where values[i] represents the value of the ith sightseeing spot.
 * Two sightseeing spots i and j have a distance j - i between them.
 * The score of a pair (i < j) of sightseeing spots is values[i] + values[j] + i - j:
 * the sum of the values of the sightseeing spots, minus the distance between them.
 * Return the maximum score of a pair of sightseeing spots.
 * 8 + 1 + 0- 1 = 9
 * 8 + 5+ 0- 2 = 11
 * 8+ 2 +0 -3 = 7
 * 8 + 6 + 0- 4 = 10
 */
// 0- 1 = -1
// -1 -1 = - 2
 //
fun maxScoreSightseeingPair(values: IntArray): Int {
    var maxScore = Integer.MIN_VALUE
    var prevScore = values[0]

    for(i in 1..<values.size) {
        maxScore = max(maxScore, prevScore + values[i] - i)
        prevScore = max(prevScore, + values[i] + i)

    }
    return maxScore
}


