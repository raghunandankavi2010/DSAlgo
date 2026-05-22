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

package programs.others

/** 1234
 * The sum of 1+2+3+4 = 10,
 * digSum(x) == 10
 * Hence ans will be 1+0 = 1
 */

fun main(){
    val n = 1234
    println(digisum(n))
}

fun digisum(num: Int): Int{
    var n = num
    var sum = 0
    while(n>0 || sum>9 ){
        if(n==0){
            n = sum
            sum = 0
        }
        sum += n % 10
        n /= 10
    }
    return sum
}