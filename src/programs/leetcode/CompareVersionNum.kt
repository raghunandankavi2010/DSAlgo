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

package programs.leetcode


fun main() {
    val version2 = "1.0.1"
    val version1 = "1"
    println("1 vs 1.0.1: ${compareVersion(version1, version2)}")

    val version3 = "1.0"
    val version4 = "1"
    println("1.0 vs 1: ${compareVersion(version3, version4)}")

    val version5 = "1.1"
    val version6 = "1.0"
    println("1.1 vs 1.0: ${compareVersion(version5, version6)}")

    val version7 = "1.0.0.1"
    val version8 = "1.0.0"
    println("1.0.0.1 vs 1.0.0: ${compareVersion(version7, version8)}")

    val version9 = "0.9.1"
    val version10 = "1.0"
    println("0.9.1 vs 1.0: ${compareVersion(version9, version10)}")
}


private fun compareVersion(version1: String, version2: String): Int {

    val version1Parts = version1.split(".").map { it.toInt() }
    val version2Parts = version2.split(".").map { it.toInt() }

    val size1 = version1Parts.size
    val size2 = version2Parts.size

    var i = 0

    while(i < size1 || i < size2) {
        val firstNum = if (i < size1) version1Parts[i] else 0
        val secondNum = if (i < size2) version2Parts[i] else 0

        if (firstNum > secondNum) {
            return  1
        }
        if (firstNum < secondNum) {
            return  -1
        }
        i++
    }

    return 0
}