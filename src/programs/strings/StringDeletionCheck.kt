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
 *  Given two strings s0 and s1, return whether you can obtain s1 by removing 1 letter from s0.
 * Constraints
 * 0 ≤ n ≤ 200,000 where n is the length of s0
 * 0 ≤ m ≤ 200,000 where m is the length of `s1
 */
fun main() {
    val s1 = "xx"
    val s2 = "nn"
    val isPossible = checkIfPossible(s1,s2)
    println("$isPossible")
}

fun checkIfPossible(s1: String, s2: String): Boolean {

   if(s1.length !=  s2.length+1) return false
    s1.forEachIndexed { index, value ->
        if(s2[index] != s1[index]){
            return s2.substring(index) == s1.substring(index+1)
        }
    }
    return true
}
