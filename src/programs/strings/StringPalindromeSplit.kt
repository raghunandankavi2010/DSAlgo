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
 * You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.

When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.

Return true if it is possible to form a palindrome string, otherwise return false.

Notice that x + y denotes the concatenation of strings x and y.



Example 1:

Input: a = "x", b = "y"
Output: true
Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
aprefix = "", asuffix = "x"
bprefix = "", bsuffix = "y"
Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
Example 2:

Input: a = "abdef", b = "fecab"
Output: true
Example 3:

Input: a = "ulacfd", b = "jizalu"
Output: true
Explaination: Split them at index 3:
aprefix = "ula", asuffix = "cfd"
bprefix = "jiz", bsuffix = "alu"
Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
Example 4:

Input: a = "xbdef", b = "xecab"
Output: false


Constraints:

1 <= a.length, b.length <= 105
a.length == b.length
a and b consist of lowercase English letters
 */
fun main() {
    val a = "ulacfd"
    val b = "jizalu"

    println(checkPalindromeFormation(a,b))
}

fun checkPalindromeFormation(a: String, b: String): Boolean {

  return checkPalin(a,b) || checkPalin(b,a)
}

fun checkPalin(a: String, b: String): Boolean{
    var l = 0
    var r = b.length-1

    while(l<=r && a[l]==b[r]){
        l++
        r--
    }
    if(l>=r){
        return true
    }
    return isPalindrome(a.substring(l,r+1)) || isPalindrome(b.substring(l,r+1))
}

fun isPalindrome(s: String): Boolean {
    var l = 0
    var r = s.length-1
    while(l<r && s[l]==s[r]) {
            l++
            r--
    }
 return l>=r
}
