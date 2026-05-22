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

import java.util.*
import kotlin.collections.ArrayList

/**
 *  given [1,2,3] array
 *  print all permutations of this array
 */

fun main() {
    val numbs = intArrayOf(1, 2, 3)
    // Iteratively
    /*val listOfLists = permute(numbs)
    for (list in listOfLists) {
        for (num in list) {
            print(num)
        }
        println("")
    }*/

    // Recursively
    recursivePermutation(numbs)
    val list = ArrayList<MutableList<Int>>()
    backTrack(list,ArrayList(),numbs)
    list.forEach {
        println(it)
    }

}

fun backTrack(list: ArrayList<MutableList<Int>>, tempList: ArrayList<Int>, nums: IntArray) {
    if(tempList.size == nums.size) {
        list.add(ArrayList(tempList))
        return
    }
    for(i in nums.indices) {
        if(tempList.contains(nums[i])) continue
        tempList.add(nums[i])
        backTrack(list,tempList,nums)
        tempList.removeAt(tempList.size - 1)
    }


}

fun recursivePermutation(nums: IntArray) {

    permutation(nums, 0, nums.size - 1)

}

fun permutation(nums: IntArray, start: Int, end: Int) {
    if (start == end) {
        printArray(nums)
    } else {
        for (i in start..end) {
            swap(nums, start, i)
            permutation(nums, start + 1, end)
            swap(nums, start, i)
        }
    }
}

fun swap(arr: IntArray, x: Int, y: Int) {
    val temp = arr[x]
    arr[x] = arr[y]
    arr[y] = temp
}


fun printArray(nums: IntArray) {

    nums.forEach {
        print(it)
    }
    println("")
}

fun permute(numbs: IntArray): LinkedList<List<Int>> {

    val result = LinkedList<List<Int>>()
    var rSize: Int
    result.add(ArrayList())

    for (num in numbs) {
        rSize = result.size
        while (rSize > 0) {
            val permutation = result.pollFirst()

            for (i in 0..permutation.size) {
                val newPermutation = ArrayList<Int>(permutation)
                newPermutation.add(i, num)
                result.add(newPermutation)
            }

            rSize--
        }
    }

    return result
}
