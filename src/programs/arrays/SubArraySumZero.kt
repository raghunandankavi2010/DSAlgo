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

import java.util.ArrayList




fun main() {

    val array = intArrayOf(-3, 2, 3, 1, 6)
    val isSubArrayZero = findSubArrayZero(array)
    println(isSubArrayZero)
    val out: ArrayList<Pair<Int,Int>> = findAllSubArrayZero(array)

    if (out.size == 0) println("No subarray exists") else print(out)
}

fun findSubArrayZero(array: IntArray): Boolean {

    val set = HashSet<Int>()
    var sum = 0
    array.forEach {
        sum += it
        if (it == 0 || sum == 0 || set.contains(sum))
            return true
        set.add(sum)
    }
    return false
}

fun findAllSubArrayZero(array: IntArray): ArrayList<Pair<Int,Int>>  {
    val map = HashMap<Int,ArrayList<Int>>()
    val out: ArrayList<Pair<Int,Int>> = ArrayList<Pair<Int,Int>>()

    var sum = 0
    array.forEachIndexed { index, element ->
        sum += element
        if(sum==0){
            out.add(Pair(0,index))
        }
        var al = ArrayList<Int>()

        if(map.containsKey(sum)){
            al = map[sum]!!
            al.forEach {
                out.add(Pair(al[it] + 1,index))
            }
        }
        al.add(index)
        map[sum] = al

    }
    return out
}
