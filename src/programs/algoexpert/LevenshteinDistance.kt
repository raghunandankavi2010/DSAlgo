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

fun main() {
    val s1 = "abc"
    val s2 = "yabd"
    val distance = levenshteinDistance(s1, s2)
    println(distance)
}

private fun levenshteinDistance(s1: String, s2: String): Int {

    val m = s1.length
    val n = s2.length
    val dp = Array(m + 1) { IntArray(n + 1) }

    for(j in 0.. n) {
        dp[0][j] = j
    }

    for(i in 0.. m) {
        dp[i][0] = i
    }

    for(i in 1 .. m) {
        for (j in 1 .. n) {
            val cost = if(s1[i-1] == s2[j-1]) 0 else 1
            val deletionCost = dp[i-1] [j] + 1
            val insertionCost = dp[i] [j-1] + 1
            val substitutionCost = dp[i - 1][j - 1] + cost
            dp[i] [j] = minOf(deletionCost,insertionCost, substitutionCost)
        }
    }
    return dp[m][n]
}
