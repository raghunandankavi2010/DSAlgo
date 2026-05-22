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

package programs.arrays


fun main() {
    val height = intArrayOf(1,8,6,2,5,4,8,3,7)
    var low = 0
    var high = height.size -1
    var maxArea = 0
    while(low < high) {
        if(height[low] < height[high]) {
            maxArea = Math.max(maxArea,height[low] * (high - low))
            low ++
        } else {
            maxArea = Math.max(maxArea,height[high] * (high - low))
            high --
        }

    }

   println("Maximum water storage is $maxArea")
}