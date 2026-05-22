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

/* Peak element in array
   A peak element is a element that is greater than its neighbours
*
* */
fun main() {
    val nums = arrayOf(1,2,3,1)
    peakElement(nums)
}

fun peakElement(arr: Array<Int>) {
    val n = arr.size
    if(n == 1){
        println(arr[0])
    } else if(n == 2 && arr[0] > arr[1]) {
        println(arr[0])
    } else if(arr[n-1] >= arr[n-2]){
        println(arr[n-1])
    }

    for( i in arr.indices){
        if(i-1 >= 0 && i+1 <= arr.size-1) {
            if(arr[i] > arr[i-1] && arr[i+1] < arr[i]) {
                println(arr[i-1])
            } else{
                continue
            }
        }
    }

}
