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

package programs.numbers

import kotlin.math.floor
import kotlin.math.sqrt

fun main(){
    val num = 144
    val check = isPerfectSquare2(num)
    println(check)
}
fun isPerfectSquare2(x: Int): Boolean {

    // Find floating point value of
    // square root of x.
    val sr = sqrt(x.toDouble())

    // If square root is an integer
    return sr - floor(sr) == 0.0
}

fun isPerfectSquare(num: Int): Boolean {

    var l = 1
    var r = num
    while(l<=r){
        val mid = (l+r)/2
        val squaredMid = mid * mid
        println(squaredMid)
        when {
            squaredMid == num ->  {
                println("Perfect square $squaredMid")
                return true
            }
            squaredMid > num -> {
                r = mid-1
            }
            else -> {
                l  = mid+1
            }
        }
    }
    return false
}
