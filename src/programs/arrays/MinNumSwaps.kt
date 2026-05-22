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
 *  Minimum number of swaps to group all ones together
 */
fun main() {
    val arr = arrayOf(1,0,1,0,1,0,1,1,1)

    // calculate total number of ones. that will be our window
    val totalOnes = arr.count { it == 1}
    var currZeros = 0
    var ans: Int

    // calculate the number of zeros in the first window
    for(i in 0 until totalOnes) {
        if(arr[i] == 0) {
            currZeros += 1
        }
    }
    ans = currZeros

    // calculate number of zeros in from 2nd window to last
    // if the window size exceeds remove the first item by doing minus 1
    // update the ans
    for(i in totalOnes until arr.size) {
        if(arr[i] == 0) {
            currZeros += 1
        }
        if (arr[i - totalOnes] == 0)
            currZeros -= 1
        ans = ans.coerceAtMost(currZeros)
    }

    println(ans)

}

