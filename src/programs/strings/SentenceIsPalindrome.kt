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
    val s = "Abc def ghi jklm."
    val ch = s.toCharArray()
    var i = 0
    var j = s.length -1
    var isPalindrome = true
    while (i < s.length - 1) {

        if(!Character.isLetterOrDigit(ch[i]) && !Character.isLetterOrDigit(ch[j]) && Character.toLowerCase(ch[i]) == Character.toLowerCase(ch[j]) ){
            i++
            j--
        } else if(Character.isLetterOrDigit(ch[i])){
            i++
        } else if(Character.isLetterOrDigit(ch[j])) {
            j--
        } else {
            isPalindrome = false
            break
        }
    }
    if(isPalindrome) {
        println("Palindrome")
    } else {
        println("Not palindrome")
    }
}