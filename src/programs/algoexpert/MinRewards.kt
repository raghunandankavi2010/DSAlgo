package programs.algoexpert

import kotlin.math.max

fun main() {
    val scores = listOf(4, 2, 1, 3)
    println("Total rewards (Naive): ${minRewardsOptimal(scores)}")
}

private fun minRewardsNaive(scores: List<Int>): Int {
    val rewards = IntArray(scores.size){ 0 }

    rewards[0] = 1

    for(i in 1 until scores.size) {
        if(scores[i] > scores[i-1]) {
            rewards[i] = rewards[i-1] + 1
        } else {
            rewards[i] = 1
            var j = i-1
            while(j >= 0 && scores[j] > scores[j+1]) {
                rewards[j] = max(rewards[j], rewards[j+1] + 1)
                j--
            }
        }
    }

    return rewards.sum()
}

private fun minRewardsOptimal(scores: List<Int>): Int {
    val rewards = IntArray(scores.size) { 1 }

    for (i in 1 until scores.size) {
        if (scores[i] > scores[i - 1]) {
            rewards[i] = rewards[i - 1] + 1
        }
    }

    for (i in scores.size - 2 downTo 0) {
        if (scores[i] > scores[i + 1]) {
            rewards[i] = max(rewards[i], rewards[i + 1] + 1)
        }
    }

    return rewards.sum()
}