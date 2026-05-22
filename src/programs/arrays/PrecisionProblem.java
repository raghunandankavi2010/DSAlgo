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

package programs.arrays;

import static java.lang.String.format;
/**
 * https://www.hackerrank.com/challenges/plus-minus/problem
 */

public class PrecisionProblem {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        float countPos = 0, countNeg = 0, countZero = 0;
        float size = arr.length;

        for (Integer value : arr) {
            if (value > 0) {
                countPos++;
            }
            else if (value < 0) {
                countNeg++;
            }
           else{
                countZero++;
            }

        }
        double result1 = countPos/size;
        double result2 = countNeg/size;
        double result3 = countZero/size;
        System.out.println(format("%.6f", result1));
        System.out.println(format("%.6f", result2));
        System.out.println(format("%.6f", result3));
    }
    

    public static void main(String[] args) {

        int[] arr = {-4, 3, -9, 0, 4, 1};
        plusMinus(arr);
    }
}
