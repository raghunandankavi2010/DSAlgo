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

package programs.others

/**
 * Given input 28 and 2+8 = 10
 * find a number greater than 28 whose sum is 10
 * adding 9 to 28 is 37 and 7+3 = 10
 */
fun main() {

    val input = 28
    val number = findNumber(input)
    println(number)

}

fun findNumber(input: Int): Int {

    return 9 + input
}
