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


fun main(){
    val array = intArrayOf(1, 3, 5, 2, 1, 9, 3, 1, 1, 1)
    findDuplicates(array)
}

fun findDuplicates(array: IntArray) {

    val map: MutableMap<Int,Int> = mutableMapOf()

    array.forEach {
        if(!map.containsKey(it)){
            map[it] = 1
        }else{
            map[it] = map.getValue(it)+1
        }
    }

    val noDuplicates = map.filterValues { value -> value>1 }
    println(noDuplicates)
}
