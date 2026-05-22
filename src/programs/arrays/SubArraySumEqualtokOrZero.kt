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


fun main() {

    val intArray = arrayOf(5,4,12,1,2)
    subArraySum(intArray,3)
    //subArraySumEqualtoZero(intArray)
   // val k = 3
    //println("\nNumber of Sub Array equal to $k")
    //val secondArray = arrayOf(3,4,-1)

    //subArraySumEqualToK(secondArray,k)
}

/**
 * This is similar to sliding window technique.
 * You keep adding sum until it's less than target
 * if it's greater than target keep subtracting it from the start
 * incrementing start index
 */

fun subArraySum(intArray: Array<Int>,k: Int) {
    var start = 0
    var sum = 0
    var end = 0
    for(i in intArray.indices) {

        sum += intArray[i]
        while(sum > k ) {
            sum -= intArray[start]
            start++
        }
        if(sum == k){
            end = i
            break
        }
    }
    println("$start $end")
}

fun subArraySumEqualToK(intArray: Array<Int>, k: Int) {
    var sum = 0
    var res = 0
    val hashMap = HashMap<Int, Int>()
    hashMap[0] = 1
    for (i in intArray.indices) {
        sum += intArray[i]
        if (hashMap.containsKey(sum - k)) {
            res += hashMap[sum - k]!!
        }
        hashMap[sum] = hashMap.getOrDefault(sum, 0) + 1
    }
    println(res)

}

fun subArraySumEqualtoZero(intArray: Array<Int>) {
    val hashMap = HashMap<Int,Int>()
    var flag = false
    var maxSum = 0
    var end = 0
    var start = 0

    for(i in intArray.indices) {
        maxSum += intArray[i]
        if(hashMap.containsKey(maxSum) || maxSum == 0 || intArray[i] == 0) {
            flag = true
            end = i
            start = hashMap.getOrDefault(maxSum,-1) + 1
            if(start == -1){
                start = 0
            }
            break
        } else {
            hashMap.put(maxSum,i)
        }
    }

    if(flag) {
        println("Yes $start $end")
        print("SubArray : ")
        for(i in start.. end){
            print("${intArray[i]} ")
        }
    } else {
        println("No")
    }
}

