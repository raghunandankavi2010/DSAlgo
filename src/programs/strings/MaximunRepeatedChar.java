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

/**
 * Maximum occurring character in an input string
 */
public class MaximunRepeatedChar {

    public static void main(String[] args){
        String input = "aaankvdfda";
        int max = 0;
        char result = 0;
        int[] count = new int[256];
        for(int i=0;i<input.length();i++){
            count[input.charAt(i)]++;
            if (max < count[input.charAt(i)]) {
                max = count[input.charAt(i)];
                result = input.charAt(i);
            }
        }
        System.out.println(result+" "+max);
    }
}
