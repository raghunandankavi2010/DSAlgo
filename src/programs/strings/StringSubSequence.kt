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
 * Given a String find all subsequences of given length k
 * Given String s = "ab int k = 2
 * ab ba are subsequences of length 2
 * without duplicates
 */
fun main() {
    var inputString = "aabcc"
    var withoutRepeated = ""
    val set = HashSet<Char>()
    for(char in inputString) {
        if(set.add(char))
            withoutRepeated+= char
    }
    inputString = withoutRepeated
    permuteSubSequence(inputString)
}

fun permuteSubSequence(inputString: String) {
    permute("", inputString, 3)
}

private fun permute(perm: String, word: String, k: Int) {
    if (k == 0) {
        println(perm)
    } else {
        for (i in word.indices) {
            permute(perm + word[i], word.substring(0, i) + word.substring(i + 1), k - 1)
        }
    }
}