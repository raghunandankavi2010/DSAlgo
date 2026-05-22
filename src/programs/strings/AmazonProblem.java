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

public class AmazonProblem {

    public static void main(String[] args) {
        System.out.println(orignial("cbdae"));
    }

    private static final StringBuilder stringBuilder = new StringBuilder();

    private static String orignial(String input1) {
        StringBuilder sb = getString(new StringBuilder(input1));
        return sb.toString();

    }


    private static StringBuilder getString(StringBuilder source) {
        stringBuilder.append(source.charAt(0));
        source.deleteCharAt(0);
        while (source.length() > 0) {
            if (source.length() % 2 == 0) {
                stringBuilder.insert(0, source.charAt(0));
            } else {
                stringBuilder.append(source.charAt(0));
            }
            source.deleteCharAt(0);
        }
        return stringBuilder;
    }
}
