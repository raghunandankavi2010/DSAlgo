/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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