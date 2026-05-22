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
    val array = arrayOf(1,2,1)
    val output = totalFruit(array)
    println(output)
}

fun totalFruit(fruits: Array<Int>): Int {
    var lastFruit = -1
    var secondLastFruit = -1
    var lastFruitCount = 0
    var currMax = 0
    var max = 0

    fruits.forEach { fruit ->

        if(fruit == lastFruit || fruit == secondLastFruit){
            currMax += 1
        } else {
            currMax = lastFruitCount + 1
        }
        if(fruit == lastFruit){
            lastFruitCount += 1
        } else {
            lastFruitCount = 1
        }

        if(fruit != lastFruit) {
            secondLastFruit  = lastFruit
            lastFruit = fruit
        }

        max = Math.max(currMax,max)

    }
    return max

}