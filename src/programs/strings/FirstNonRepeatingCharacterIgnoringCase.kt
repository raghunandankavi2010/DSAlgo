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


/**
 * Aaditya
 * a - occurs 3
 * while D occurs only once
 * While comparing case is ignored but while printing
 * print original character
 */


fun main() {
        val input1 = "AaDitya"
        for (i in input1.indices) { //1
            var flag = false
            val first = input1[i] // a
            for (j in input1.indices) {
                if (i != j) { // if you are at second position D ignore comparing it with itself
                    val second = input1[j]
                    if (Character.toLowerCase(first) == Character.toLowerCase(second)) { // ignore case and compare
                        flag = true
                        break
                    }
                }
            }
            if (!flag) {
                println(first)
                break
            }
        }
}