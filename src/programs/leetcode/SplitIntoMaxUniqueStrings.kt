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

fun maxUniqueSplit(s: String): Int {
    fun backtrack(start: Int, unique: MutableSet<String>): Int {
        if (start == s.length) {
            return unique.size
        }

        var maxSplit = 0
        for (end in start + 1..s.length) {
            val substring = s.substring(start, end)
            if (substring !in unique) {
                unique.add(substring)
                maxSplit = maxOf(maxSplit, backtrack(end, unique))
                unique.remove(substring)
            }
        }
        return maxSplit
    }

    return backtrack(0, mutableSetOf())
}

// Example usage:
fun main() {
    println(maxUniqueSplit("ababccc"))  // Output: 5
    println(maxUniqueSplit("aba"))      // Output: 2
    println(maxUniqueSplit("aa"))       // Output: 1
}
