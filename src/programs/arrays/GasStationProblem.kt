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
    val gas = intArrayOf(1, 2, 3, 4, 5)

    val cost = intArrayOf(3, 4, 5, 1, 2)

    println("Gas station at index ${getGasStation(gas, cost)}")
}

/**
 *  if tank at any index is less than 0 this mean you can discard all index before this point
 *  this is hard to understand but we need to have more than couple of examples to figure this trick
 */

fun getGasStation(gas: IntArray, cost: IntArray): Int {

    var totalDiff = 0
    var starting = 0
    var tank = 0
    gas.forEachIndexed { index, element ->
        totalDiff += element - cost[index]
        tank +=  element - cost[index]
        if (tank < 0) {
            starting += 1
            tank = 0
        }

    }
    return if (totalDiff < 0) {
        -1
    } else {
        starting
    }

}
