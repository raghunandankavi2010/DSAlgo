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

package programs.algoexpert

fun main() {
    val arr = mutableListOf(4, 6, 3)
    val result = missingMoreNumbers(arr)
    println("Missing more numbers: $result")

    val arr2 = mutableListOf(4, 5, 3)
    val result2 = missingNumbers(arr2)
    println("Missing two numbers: $result2")

    val arr3 = mutableListOf(4, 5, 3, 1)
    val result3 = missingOneNumber(arr3)
    println("Missing one number: $result3")
}

fun missingOneNumber(arr3: MutableList<Int>): Int {
    val n = arr3.size + 1
    var missing = (n *(n+1))/2
    arr3.forEach {
        missing -= it
    }
    return missing
}

fun missingNumbers(nums: MutableList<Int>): List<Int> {
   val set = HashSet<Int>()
    for( i in 1.. nums.size+2) {
        set.add(i)
    }
    nums.forEach {
        set.remove(it)
    }
    return set.toMutableList()
}


fun missingMoreNumbers(nums: MutableList<Int>): List<Int> {
    val set = HashSet<Int>()
    val maxElement = nums.maxOf { it }
    for( i in 1.. maxElement) {
        set.add(i)
    }
    nums.forEach {
        set.remove(it)
    }
    return set.toMutableList()
}
