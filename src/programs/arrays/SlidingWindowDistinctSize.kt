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
 * Count Distinct Elements in every Window of size k in a given array
 * 1,2,2,1,3,1,1,3
 * 1,2,2,1 is of size k
 * distinct elements size is 2
 *
 */

fun main() {
    val array = intArrayOf(1,2,2,1,3,1,1,3)
    val k= 4
    val map = HashMap<Int, Int>()
    for(i in 0 until k){
        map[array[i]] = map.getOrDefault(array[i],0)+1
    }

    println(map.size)
    for(index in k until array.size){

        if(map[array[index-k]] == 1){
            map.remove(array[index-k])
        } else {
            val value = map[array[index-k]]?.minus(1)
            if(value != null) {
                map[array[index - k]] = value
            }
        }
        map[array[index]] = map.getOrDefault(array[index],0)+1
        println(map.size)
    }
}