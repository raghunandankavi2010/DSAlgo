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

import java.lang.StringBuilder

fun main() {
    val input = "021"
    val output = buildParenthesis(input)
    println(output)

}

fun buildParenthesis(input: String): String {
    val chars = input.toCharArray()
    var curr = 0
    val sb = StringBuilder()
    for (char in chars) {
        val num = char - '0'
        while (curr < num) {
           sb.append("(")
            curr++
        }
        while(curr > num) {
            sb.append(")")
            curr--
        }
        sb.append(char)
    }
    // add remaining closing braces at the end
    while(curr>0){
        sb.append(")")
        curr--
    }
    return sb.toString()
}
