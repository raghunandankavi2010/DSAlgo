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


fun main() {
    var x = 2.0
    val n = 10

    if(n < 0) {
        x = 1/x
    }
    val result = power(x,Math.abs(n), 1.0)
    println(String.format("%.5f", result))
}

fun power(x: Double, n: Int, result: Double): Double {
    if(n == 0) {
       return result
    }

    var res = result
    res *=  x
    return power(x,n-1,res)
}
