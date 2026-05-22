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
 *  Given two String a and b interleave the string to create a new String
 *  a = abc
 *  b. def
 *  output = adbecf
 *
 */

fun main() {
    val a = "ab"
    val b = "def"
    val result = interleave(a, b)
    println(result)
}

fun interleave(a: String, b: String): String {
    val sb = StringBuilder()
        var i = 0
        while (i < a.length or b.length) {
            if(i < a.length) {
                sb.append(a[i])
            }
            if(i < b.length) {
                sb.append(b[i])
            }
            i++
        }

    return sb.toString()
}
