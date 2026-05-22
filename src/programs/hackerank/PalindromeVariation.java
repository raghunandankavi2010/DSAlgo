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

package programs.hackerank;

/**
 * James found a love letter that his friend Harry has written to his girlfriend. James is a prankster, so he decides to meddle with the letter. He changes all the words in the letter into palindromes.
 *
 * To do this, he follows two rules:
 *
 * He can only reduce the value of a letter by , i.e. he can change d to c, but he cannot change c to d or d to b.
 * The letter a may not be reduced any further.
 * Each reduction in the value of any letter is counted as a single operation. Find the minimum number of operations required to convert a given string into a palindrome.
 *
 * For example, given the string , the following two operations are performed: cde → cdd → cdc.
 */
public class PalindromeVariation {

    public static void main(String[] args) {
        String s = "abcd";
        convertToPalindrome(s);

    }

    private static void convertToPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        char[] strChar = s.toCharArray();
        int count = 0;
        while (low <= high) {
            if (strChar[low] == strChar[high] ) {
                low++;
                high--;
            } else if (strChar[low] != strChar[high] && strChar[low] > strChar[high]) {
                char val;
                while (strChar[low] != strChar[high]) {
                    int ascii = strChar[low];
                    ascii--;
                    val = (char) ascii;
                    strChar[low] = val;
                    count++;
                }
                low++;
                high--;
            } else if(strChar[low] != strChar[high] && strChar[low] < strChar[high]) {
                char val;
                while (strChar[high] != strChar[low]) {
                    int ascii = strChar[high];
                    ascii--;
                    val = (char) ascii;
                    strChar[high] = val;
                    count++;
                }
                low++;
                high--;
            }
        }
        System.out.println(String.valueOf(strChar)+" "+count);
    }
}
