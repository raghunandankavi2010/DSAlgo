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

fun partition(s: String): List<List<String>> {

    val currentPartition  = mutableListOf<String>()
    val result = mutableListOf<List<String>>()
    val n = s.length

    fun isPalindrome(sub: String): Boolean {
        return sub == sub.reversed()
    }
    fun backtrack(startIndex: Int) {
        if(startIndex == n) {
            result.add(ArrayList(currentPartition))
            return
        }
        for( i in startIndex until n) {
            val currentSubString = s.subSequence(startIndex, i+1)
            if(isPalindrome(currentSubString.toString())) {
                currentPartition.add(currentSubString.toString())
                backtrack(i+1)
                currentPartition.removeAt(currentPartition.size - 1)
            }
        }
    }

    backtrack(0)

    return result

}


fun main() {
    val input = "aab"
    println(partition(input))
}