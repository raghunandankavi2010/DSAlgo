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
import java.util.*

/**
 *  Given String s1 = "ab#c"
 *  where # represents a backspace ie delete character b results in ac
 *  Similarly for String s1 = "ad#c" results is ac
 *  comparing s1 == s2 is true else false
 */

fun main() {

    val s1 = "ab#c"
    val s2 = "ad#c"
    val isTrue = check(s1, s2)
    println(isTrue)

}

fun check(s1: String, s2: String): Boolean {

    val string1 = processString(s1)
    val string2 = processString(s2)
    println("$string1 $string2")
    return string1 == string2
}

fun processString(s: String): String {
    val stack = Stack<Char>()
    val result = StringBuilder()
    val sCharArray = s.toCharArray()
    var temp = ' '
    for (i in sCharArray.indices) {
        if (sCharArray[i] != '#') {
            temp = ' '
            stack.push(sCharArray[i])
        } else if (stack.isNotEmpty() && temp != '#') {
            temp = '#'
            stack.pop()
        }
    }

    while (stack.isNotEmpty()) {
        result.insert(0,stack.pop())
    }

    return result.toString()

}
