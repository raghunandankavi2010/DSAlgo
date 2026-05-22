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

package programs.hackerank


fun main() {

    val mList: MutableList<Int> = mutableListOf()

    mList.add(5)
    mList.add(5)
    mList.add(3)
    mList.add(2)

    val result = listOfPiles(mList)
    println(result)
}

private fun listOfPiles(mList: MutableList<Int>): Int {
    var count = 0
    mList.sort()

    var prev: Int = mList[0]

    for (i in 1 until mList.size) {
        if (mList[i] > prev) {
            count++

            mList[i] = prev
            prev = mList[i]
        } else {
            prev = mList[i]
        }
    }
    return count
}
