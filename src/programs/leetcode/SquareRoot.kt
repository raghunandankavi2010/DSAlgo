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

package programs.leetcode

fun main() {
    val x = 8
    val output = mySqrt(x)
    println(output)
}

private fun mySqrt(x: Int): Int {

    if(x == 0) return 0

    var start = 1
    var end = x

    while(end >= start) {
        val mid = start+(end-start)/2
        val square = mid.toLong() * mid.toLong()
        if(square == x.toLong()) {
            return mid
        } else if(square < x.toLong()) {
            start = mid + 1
        } else {
            end = mid - 1
        }
    }
    return end
}