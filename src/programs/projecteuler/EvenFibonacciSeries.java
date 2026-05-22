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

package programs.projecteuler;

public class EvenFibonacciSeries {

    public static void main(String[] args) {

        int b = 2;
        int target = 4000000;

        int fib = 0;
        int res = 0;

        evenFibonacciSeries(b,fib,res);
        findSumOfEvenFibonnacciSeries(b, res,target);

    }

    private static void findSumOfEvenFibonnacciSeries(int b, int res, int target) {
        int sum = b;
        while(sum < target){
            int fib = b * 4 + res;
            sum = sum + fib;
            res = b;
            b = fib;
        }

        System.out.println("Sum of even fib series "+sum);
    }

    private static void evenFibonacciSeries(int b, int fib, int res) {
        int index = 3;
        while(index <= 6){
            fib = b*4+res;
            res = b;
            b = fib;
            index++;
        }
        System.out.println("6th even fib "+fib);
    }
}
