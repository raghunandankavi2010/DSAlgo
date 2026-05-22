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

package programs.strings;

public class LowestCommonPrefix {

    public static void main(String[] args){
        String[] input = {"flower","flow","flight"};
        String output = longestCommonPrefix(input);
        System.out.println(output);
    }

    private static String longestCommonPrefix(String[] strs) {
        if ((strs == null) || (strs.length < 1)) {
            return "";
        }

        String shortestStr = strs[0];

        for (int j = 1; j < strs.length; j++) {
            if (strs[j].length() < shortestStr.length()) {
                shortestStr = strs[j];
            }
        }

        for (int j = 0; j < shortestStr.length(); j++) {
            char ch = shortestStr.charAt(j);
            for (int n = 0; n < strs.length; n++) {
                if (strs[n].charAt(j) != ch) {
                    return shortestStr.substring(0, j);
                }
            }
        }

        return shortestStr;
    }
}
