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

package programs.test;

public class Test {

    public static void main(String[] args){
        String s ="10,4,2";
        System.out.println(solution(s));

    }

    private static int solution(String s) {
        String[] array= s.split(",");
        int min=-1;
        int count =1;
        int diff;

            for (int i = 0; i <= array.length - 1; i++) {
                if (count <array.length) {
                    int start = Integer.parseInt(array[count]);
                    for (int j = 0; j <= count; j++) {
                        if (start != Integer.parseInt(array[j])) {
                            diff = start - Integer.parseInt(array[j]) ;
                            min = Math.max(diff,min);
                        }
                    }
                    count++;
                }
            }
        return min;
    }
}
