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
    println(isCircularSentence("leetcode exercises sound delightful")) // Should return true
    println(isCircularSentence("eetcode")) // Should return true
    println(isCircularSentence("leetcode eats soul")) // Should return true
    println(isCircularSentence("Leetcode is cool")) // Should return false
    println(isCircularSentence("happy Leetcode")) // Should return false
    println(isCircularSentence("Leetcode")) // Should return false
    println(isCircularSentence("I like Leetcode")) // Should return false
}

private fun isCircularSentence(sentence: String): Boolean {
    val words = sentence.split(" ")
    for (i in words.indices) {
        val lastChar = words[i].last()
        val firstChar = words[(i + 1) % words.size].first()
        if (lastChar != firstChar) {
            return false
        }
    }
    return true
}