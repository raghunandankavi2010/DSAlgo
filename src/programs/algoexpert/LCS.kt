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

    val str1 = "ZXVVYZW"
    val str2 = "XKYKZPW"
    val result = lcs(str1, str2)
    println(result)
}

private fun lcs(s1: String, s2: String): List<Char> {

    val dp = Array(s1.length + 1) { Array(s2.length + 1) { "" } }

    for (i in 1..s1.length) {
        for (j in 1..s2.length) {
            if (s1[i - 1] == s2[j - 1]) {
                dp[i][j] = dp[i - 1][j - 1] + s1[i - 1]
            } else {
                val topString = dp[i - 1][j]
                val leftString = dp[i][j - 1]
                dp[i][j] = if (topString.length > leftString.length) topString else leftString
            }
        }
    }

    return dp[s1.length][s2.length].toCharArray().toList()
}