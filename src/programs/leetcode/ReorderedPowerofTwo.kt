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
    val n = 23

    val permutations = generatePermutations(n.toString())

    var foundPowerOfTwo = false
    for (pStr in permutations) {
        if (pStr.length > 1 && pStr.startsWith('0')) {
            continue
        }

        val num = pStr.toInt()
        println("Checking $num...")

        if (isPowerOfTwo(num)) {
            foundPowerOfTwo = true
            break
        }
    }

    println(foundPowerOfTwo)

    println(reorderedPowerOf2(n))
}

private fun isPowerOfTwo(num: Int): Boolean {
    return num > 0 && (num and (num - 1)) == 0
}


private fun generatePermutations(s: String): MutableList<String> {
    val results = mutableListOf<String>()
    permuteHelper("", s, results)
    return results
}

private fun permuteHelper(permute: String, n: String, resultString: MutableList<String>) {

    if (n.isEmpty()) {
        resultString.add(permute)
        return
    }
    for (i in 0..n.length - 1) {
        permuteHelper(permute + n[i], n.substring(0, i) + n.substring(i + 1), resultString)
    }

    return
}


private fun reorderedPowerOf2(n: Int): Boolean {
    val nSignature = String(n.toString().toCharArray().apply { sort() })

    for (i in 0..30) {
        val powerOfTwo = 1 shl i

        val powerSignature = String(powerOfTwo.toString().toCharArray().apply { sort() })

        if (nSignature == powerSignature) {
            return true
        }
    }

    return false
}