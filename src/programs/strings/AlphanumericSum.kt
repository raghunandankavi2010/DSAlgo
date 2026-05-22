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
 * Given alphanumeric string calculate the sum of digits
 * A1b2
 * sum here is 3
 * Also take into account continuous digit's can be bigger num
 */
fun main() {
    val str = "A1b23c3"
    val sum = alphaNumSum(str)
    println(sum)
}

fun alphaNumSum(str: String): Int {
    var sum = 0
    var temp = "0"
    str.forEach {
        if(it.isDigit()) {
            temp = "$temp$it"
        } else {
            sum += temp.toInt()
            temp = "0"
        }
    }
    sum += temp.toInt()
    return sum
}
