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
    val expression = "2-1-1"

    diffWaysToCompute(expression).forEach {
        println(it)
    }
}

fun diffWaysToCompute(expression: String?): List<Int> {
    return solve(expression!!)
}

fun solve(expression: String): List<Int> {
    val result = mutableListOf<Int>()

    expression.forEachIndexed { index, currChar ->
        if (currChar == '+' || currChar == '-' || currChar == '*') {
            val left = solve(expression.substring(0, index))
            val right = solve(expression.substring(index + 1))
            for (x in left) {
                for (y in right) {
                    when (currChar) {
                        '+' -> {
                            result.add(x + y)
                        }

                        '-' -> {
                            result.add(x - y)
                        }

                        else -> {
                            result.add(x * y)
                        }
                    }
                }
            }
        }
    }

    if (result.isEmpty()) {
        result.add(Integer.parseInt(expression))
    }
    return result
}


