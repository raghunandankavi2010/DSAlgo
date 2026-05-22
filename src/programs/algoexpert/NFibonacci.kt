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
    val n = 5
    val result = getNthFib(n)
    println(result)
}

private fun getNthFib(n: Int): Int {
    if (n <= 1) return 0
    if (n == 2) return 1

    var prev = 0
    var curr = 1


    for(i in 3.. n) {
        val nextFib = prev + curr
        prev = curr
        curr = nextFib
    }

    return curr
}
