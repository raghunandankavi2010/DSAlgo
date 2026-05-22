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

package programs.strings

/**
 * https://leetcode.com/problems/buddy-strings/
 */
fun main() {

    val a = "abab"
    val b = "baab"
    println(isBuddyString(a, b))
}

private fun isBuddyString(A: String, B: String): Boolean {
    when {
        A.length != B.length -> {
            return false
        }
        A == B -> {
            val set = mutableSetOf<Char>()
            A.forEach {
                if (set.contains(it))
                    return true
                set.add(it)
            }
            return false
        }
        else -> {
            val list = mutableListOf<Int>()
            for (i in A.indices) {
                if (A[i] != B[i]) {
                    list.add(i)
                }
            }
            return list.size == 2 && A[list[0]] == B[list[1]] && A[list[1]] == B[list[0]]

        }
    }
}


