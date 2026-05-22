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

private val mapof = mapOf(
    "2" to "abc",
    "3" to "def",
    "4" to "ghi",
    "5" to "jkl",
    "6" to "mno",
    "7" to "pqrs",
    "8" to "tuv",
    "9" to "wxyz"
)

fun main() {
    val digits = "2"
    val output = letterCombinations(digits)
    println(output)
}

private fun letterCombinations(digits: String): List<String> {
    if (digits.isEmpty()) {
        return emptyList()
    }

    val result = mutableListOf<String>()
    combination(digits,result)
    return result
}

private fun combination(digits: String,result: MutableList<String>, index: Int = 0, comb: String = "") {
    if(comb.length == digits.length) {
        result.add(comb)
        return
    }

    if(index < digits.length ) {
        val currentString = digits[index].toString()
        val curr = mapof[currentString]

        curr?.forEach { char ->
            combination(digits, result, index + 1, comb + char)
        }
    }
}