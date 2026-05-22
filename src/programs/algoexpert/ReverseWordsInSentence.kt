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
    val s1 = "the sky is blue"
    println("Original:  '$s1'")
    println("Reversed:  '${reverseWords(s1)}'") // Will now be correct: "blue is sky the"
}

private fun reverseWords(s: String): String {
    val charArr = s.toCharArray()
    reverse(charArr, 0, charArr.size - 1)

    var wordStart = 0
    for (i in 0..charArr.size) {
        if (i == charArr.size || charArr[i] == ' ') {
            val wordEnd = i - 1
            reverse(charArr, wordStart, wordEnd)
            wordStart = i + 1
        }
    }
    return String(charArr)
}

private fun reverse(charArr: CharArray, i: Int, j: Int) {
    var start = i
    var end = j

    while (start < end) {
        val temp = charArr[start]
        charArr[start] = charArr[end]
        charArr[end] = temp
        start++
        end--
    }
}
