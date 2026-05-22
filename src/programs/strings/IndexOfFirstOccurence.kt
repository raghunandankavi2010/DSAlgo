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
 *   Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.



Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 */
fun main() {
    val haystack = "aaa"
    val needle = "aaaa"
    println(strStr(haystack,needle))


}

fun strStr(haystack: String, needle: String): Int {
    if(needle.length > haystack.length) {
        return -1
    }
    else if (haystack == needle) {
        return 0
    } else {
        var start = 0
        var end = 0
        var found = false

        while (start < haystack.length) {
            if (end < haystack.length) {
                end = start + needle.length
                val subString = haystack.substring(start, end)
                if (subString == needle) {
                    found = true
                    break
                }
            }
            start++
        }
        if (found) return start
        else return -1
    }
}