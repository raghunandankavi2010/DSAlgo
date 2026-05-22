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

package programs.recurssion


fun main() {
    val input = "Hello"
    val s = input.toCharArray()
    val output = reverseString(input)
    println("Reversed String using recursion2 $output")
    helper(s, 0, input.length - 1)
    println("Reversed String using recursion2 $output")
    println(s)
}

private fun reverseString(input: String): String {
    if(input.isEmpty()) return ""
   return  reverseInputString(input,input.length -1,"")
}

private fun reverseInputString(input: String, index: Int,  reversed: String): String {
    if(index < 0) return reversed
    val revString = reversed + input[index]

    return reverseInputString(input.take(index),index-1,revString)
}


private fun helper(s: CharArray, left: Int, right: Int) {

    if(left > right) {
        return
    }

    val temp = s[left]
    s[left] = s[right]
    s[right] = temp

    helper(s,left +1, right -1)

}