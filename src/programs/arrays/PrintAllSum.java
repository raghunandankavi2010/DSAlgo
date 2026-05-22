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

public class PrintAllSum {

    public static void main(String[] args){
        int sum = 5;
        int[] arr = new int[5];
        int index = 0;
        printSum(arr,index,sum,sum);
    }

    private static void printSum(int[] arr, int i, int sum, int sumLeft) {
        int prev_num = (i > 0) ? arr[i - 1] : 1;
        for (int k = prev_num; k <= sum ; k++) {
            // set next element of the array to k
            arr[i] = k;

            // recur with the sum left and next location in the array
            if (sumLeft > k) {
                printSum(arr, i + 1, sum, sumLeft - k);
            }

            // if sum is found
            if (sumLeft == k) {
                printArray(arr, i);
            }
        }
    }

    private static void printArray(int[] out, int n) {
        for (int i = 0; i <= n; i++) {
            System.out.printf("%d ", out[i]);
        }
        System.out.println();
    }
}
