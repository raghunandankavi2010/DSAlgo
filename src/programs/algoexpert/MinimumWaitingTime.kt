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
    val input = mutableListOf(3,2)
    val output = minimumWaitingTime(input)
    print(output)
}
// 1,  2  ,2,     3,         6
// 0   1    1+2   1+2+2     1+2+2+3
 //0   1     3     5          8
private fun minimumWaitingTime(queries: MutableList<Int>): Int {
    // Write your code here.
    if(queries.size == 1) return 0
    queries.sort()
    var count = 0
    var newCount = 0
    for( i in 1.. queries.size -1) {
        count = count + queries[i-1]
        newCount = newCount + count

    }

    return newCount
}
