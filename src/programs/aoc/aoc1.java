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

package programs.aoc;

public class aoc1 {

   public static void main(String[] args) {
        String input = "1111";
/*       int length = input.length();
        int sum = IntStream.range(0, length)
                .filter(i -> input.charAt(i) == input.charAt((i + 1) % length))
                .map(i -> Integer.parseInt(String.valueOf(input.charAt(i))))
                .sum();
        System.out.println(sum);*/

        int sum = 0;

        for (int i = 0; i < input.length() - 1; i++) {

            if (input.charAt(i) == input.charAt(i+1)) {
                sum += Integer.parseInt(String.valueOf(input.charAt(i)));
            }
            if (i + 2 == input.length() - 1) {
                if (input.charAt(i + 2) == input.charAt(0)) {
                    sum += Integer.parseInt(String.valueOf(input.charAt(i + 2)));
                }
            }
        }
        System.out.println(sum);

    }
  /*  int sum = 0;
    int half = input.length()/2;
        for (int i = 0; i < input.length() - 1; i++) {
        if(i+half<input.length())
            if (input.charAt(i) == input.charAt(i+half)) {
                sum += Integer.parseInt(String.valueOf(input.charAt(i)))+Integer.parseInt(String.valueOf(input.charAt(i+half)));
            }

    }
        System.out.println(sum);*/


}
