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

public class StringRotation {

    public static void main(String[] args){
        String test = "abcdefg";
        String rotated = "defgabc";
        checkRotated(test,rotated);
    }

    private static void checkRotated(String test, String rotated) {
        if(test.length()!= rotated.length())
            return;
        char first = test.charAt(0);
        int index = rotated.indexOf(first);
        if(index!=-1) {
            String s1 = rotated.substring(index, rotated.length());
            String s2 = rotated.substring(0, index);
            StringBuilder sb = new StringBuilder(s1.length() + s2.length());
            sb.append(s1);
            sb.append(s2);
            if (test.equals(sb.toString())) {
                System.out.println("Given String is a rotation of original String");
            } else{
                System.out.println("Given String is not a rotation og=f original String");
            }
        }

    }
}
