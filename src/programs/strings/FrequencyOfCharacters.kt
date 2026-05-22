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

package programs.strings


fun main() {
    val input = "This is my String"

    val map = LinkedHashMap<Char, Int>()

    for (i in input.indices) {
        val ch = Character.toLowerCase(input[i])
        if (ch != ' ') {
            if (!map.containsKey(ch)) {
                map[ch] = 1
            } else {
                val count = map.getOrDefault(ch, 0)
                map[ch] = count+1
            }
        }
    }

    map.forEach { (k, v) ->
        println("$k = $v")
    }
}
