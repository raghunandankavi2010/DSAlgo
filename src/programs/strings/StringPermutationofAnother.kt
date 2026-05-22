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

@file:Suppress("KotlinConstantConditions")

package programs.strings

fun main(){

    val str1 = "Raghu"
    val str2 = "Raghu"
    println(checkPermutation(str1,str2))

}

fun checkPermutation(str1: String,  str2: String): Boolean {
    var check = true
    val map = HashMap<Char,Int>()
    str1.forEach {

        if(!map.containsKey(it)) {
            map[it] = 1
        } else {
            map[it] = map.getOrDefault(it,-100) + 1
        }
    }

    str2.forEach {

        if(!map.containsKey(it)) {
            check = false
            return check
        } else {
            map[it] = map.getOrDefault(it,-100) - 1
        }
    }

    map.forEach { (key, value) ->

        if (value != 0) {
            check = false
            return check
        }

    }

    return check
}