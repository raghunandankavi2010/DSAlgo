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


fun maximumSwap(num: Int): Int {
    val digits = num.toString().toCharArray()
    val n = digits.size

    // Array to store the max values from right to left
    val maxFromRight = IntArray(n)
    maxFromRight[n - 1] = n - 1

    // Fill the array with max indices
    for (i in (n - 2) downTo  0) {
        maxFromRight[i] = if (digits[i] > digits[maxFromRight[i + 1]]) i else maxFromRight[i + 1]
    }

    // Find the first place to swap
    for (i in digits.indices) {
        if (digits[i] != digits[maxFromRight[i]]) {
            // Swap the digits
            val temp = digits[i]
            digits[i] = digits[maxFromRight[i]]
            digits[maxFromRight[i]] = temp
            break
        }
    }

    return String(digits).toInt()
}

// Example usage:
fun main() {
    println(maximumSwap(2736))  // Output: 7236
    println(maximumSwap(9973))  // Output: 9973
}
