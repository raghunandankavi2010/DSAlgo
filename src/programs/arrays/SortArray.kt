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
    val listArray = arrayOf(0,1,0,0,1,1,0,1,0)
    var left = 0
    var right = listArray.size-1

   while(left<right) {
        if(left< right && listArray[left]==0){
            left++
        } else{
            while(listArray[right]!=0 && left<right){
                right--
            }
            val temp = listArray[left]
            listArray[left] = listArray[right]
            listArray[right] = temp
            left++
            right--
        }
    }

    listArray.forEach {
        println(it)
    }
}