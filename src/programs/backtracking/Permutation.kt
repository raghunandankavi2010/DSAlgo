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

package programs.backtracking

fun main() {
    val input = "23434343"
    val result = mutableListOf<String>()
    println(permute("", input, result))
}

fun permute(permute: String, input: String, result: MutableList<String>): MutableList<String> {
    if (permute.length == 3) {
        result.add(permute)
    }
    for (i in 0..input.length - 1) {
        permute(permute + input[i], input.substring(0, i) + input.substring(i + 1), result)
    }
    return result

}


