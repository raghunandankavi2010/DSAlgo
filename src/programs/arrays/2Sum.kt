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

package programs.arrays

/**
 * Input: nums = [2,7,11,15], target = 9
 */
fun main() {
    val arr = arrayOf(2, 7, 11, 15, 2)
    val target = 9
    val output = Array(2){0}

    val map = HashMap<Int,Int>()
    arr.forEachIndexed { index, it ->
        val x = it
        val y = target - it
        if ((map.containsKey(y))) {
            output[1] = index
            output[0] = map.getOrDefault(y,1)
            println("$x $y")
        } else if (!map.containsKey(it)) {
            map.put(it,index)
        }
    }

    println("${output[0]} ${output[1]}")
}