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

    val s1 = "apple apple"
    val s2 = "bannana"
    val array = uncommonFromSentences(s1, s2)
    array.forEach {
        println(it)
    }
}

private fun uncommonFromSentences(s1: String, s2: String): Array<String> {

    val wordCount = mutableMapOf<String, Int>()

    val splitS1 = s1.split("\\s+".toRegex())
    val splitS2 = s2.split("\\s+".toRegex())

    // Count occurrences in s1
    splitS1.forEach { word ->
        wordCount[word] = wordCount.getOrDefault(word, 0) + 1
    }

    // Count occurrences in s2
    splitS2.forEach { word ->
        wordCount[word] = wordCount.getOrDefault(word, 0) + 1
    }

    // Filter out words that appear more than once
    val uniqueWords = wordCount.filter { it.value == 1 }.keys

    return uniqueWords.toTypedArray()

}