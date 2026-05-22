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

import kotlin.math.abs

var res = 0.0
fun main() {
    val output = pow(2.0,5)
    val res = iterativeApproach(2.0,-2)
    println(res)
}

private fun pow(x: Double, n: Int): Double {

   res =  helper(x,abs(n))
    return if(n >=0) res else 1/res

}

private fun helper(x: Double, n: Int): Double {
    if(x == 0.0) return 0.0
    if(n== 0) return 1.0
    res = helper(x, n/2)
    res *= res
    return if(n%2 == 0) {
        res
    } else {
        x * res
    }
}

private fun iterativeApproach(x: Double, n: Int): Double {
    var res = 1.0
    repeat(abs(n)) {
            res *= x
    }
    return if(n >= 0)  res else  1/res

}