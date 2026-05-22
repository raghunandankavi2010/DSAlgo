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

package programs.others

/**
 * Given positive integers start and end (start < end), return the minimum number of operations needed to convert start to end using these operations:

Increment by 1
Multiply by 2
Constraints

start < end < 2 ** 31
Example 1
Input
start = 2
end = 9
Output
3
Explanation
We can multiply 2 to get 4, and then again to get 8, then add 1 to get 9.
 */

fun main() {
    val start = 4
    var end = 10
    var result: Int
    var count = 0

    while(end != start) {
        if(end % 2 != 0) {
            end -= 1
        } else {
            result = end / 2
            if( result < start) {
                count =  count + end - start
                break
            }
            end = result
        }
        count++
    }
    println(count)
}