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

package programs.hackerearth

import java.lang.StringBuilder

/**
 * Given MacOS
 * output mac_o_s
 * HackerEarth -> hacker_earth
 */
fun main(){

    val input = "MacOS"
    val output = convert(input)
    println(output)
}

fun convert(input: String): String {
    val sb = StringBuilder()
    for ((index, value) in input.withIndex()){
        if(Character.isLowerCase(value)){
            sb.append(value.lowercaseChar())
        }else {
            if(index==0){
                sb.append(value.lowercase())
            }else {
                sb.append("_")
                sb.append(value.lowercase())
            }
        }
    }
    return sb.toString()
}