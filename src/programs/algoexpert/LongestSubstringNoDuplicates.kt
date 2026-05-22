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
    val input = "dabcef"
    val output = longestSubstringWithoutDuplication(input)
    println("Longest substring without duplicates for $input is  $output")
}

private fun longestSubstringWithoutDuplication(string: String): String {
    // Write your code here.
    val hashMap = HashMap<Char, Int>()
    var start = 0
    var end = 0
    var longestStart = 0
    var longestEnd = 0

    while (end < string.length ) {
         val currChar = string[end]
         if (hashMap.contains(currChar)) {
            start = maxOf(start, hashMap.getOrDefault(currChar,0) + 1)
         }

        if( end - start > longestEnd - longestStart) {
            longestStart = start
            longestEnd = end
        }

        hashMap.put(string[end], end)
        end++
    }

    return string.substring(longestStart  , longestEnd + 1 )
}
