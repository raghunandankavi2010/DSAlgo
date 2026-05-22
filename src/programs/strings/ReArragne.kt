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

fun main() {
    val input = "vvvlo"
    val output = reArrange(input)
    println(output)

}

fun reArrange(str: String): String {
    val hash = IntArray(26)
    for (element in str) {
        hash[element - 'a']++
    }
    var max = 0
    var letter = 0
    for (i in hash.indices) {
        if (hash[i] > max) {
            max = hash[i]
            letter = i
        }
    }
    // if the max frequent char is greater than half of the string there is no way to re-arrange
    // without putting same char adjacent
    // bbbba
    // 4 b's
    // 1'a
    // total 5+6 /2 =3
    // 4 >3
    // bababb will break the problem statement
    if (max > (str.length + 1) / 2) {
        return ""
    }

    // put b at 0_2_4_6
    val res = CharArray(str.length)
    var idx = 0
    while (hash[letter] > 0) {
        res[idx] = (letter + 'a'.toInt()).toChar()
        idx += 2
        hash[letter]--
    }
    for (i in hash.indices) {
        while (hash[i] > 0) {
            if (idx >= res.size) {
                idx = 1
            }
            res[idx] = (i + 'a'.toInt()).toChar()
            idx += 2
            hash[i]--
        }
    }
    return  String(res)
}