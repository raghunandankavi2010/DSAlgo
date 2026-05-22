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
 * Given a string, find the first non-repeating character in it.
 * For example, if the input string is “GeeksforGeeks”,
 * then output should be ‘f’
 * and if input string is “GeeksQuiz”,then output should be ‘G’.
 */
fun main() {
    val str = "GeeksforGeeks"
    val cache = IntArray(26)
    for (element in str) {
        val value = Character.toLowerCase(element)
        cache[value.toInt() - 'a'.toInt()]++
    }
    for (i in str.indices) {
        val value = Character.toLowerCase(str[i])
        if (cache[value.toInt() - 'a'.toInt()] == 1) {
            println(str[i])
            break
        }
    }
}
