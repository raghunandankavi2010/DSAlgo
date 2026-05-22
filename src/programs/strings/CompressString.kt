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
    println("Compressed String ${compress("aaabbc")}")
}

fun compress(s: String): String {
    if(s.isEmpty()) return ""
    var count = 1
    var prevChar = s[0]
    val sb = StringBuilder()
    for(i in 1 until s.length) {
        if(s[i] == prevChar){
            count ++
        } else {
            sb.append("${prevChar}$count")
            prevChar = s[i]
            count = 1
        }
    }
    sb.append("${prevChar}$count")
    return sb.toString()
}