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

import java.util.Arrays;

/**
 * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. (O(Log(N)))
 */

public class UberProblem {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3,4};
        int x = 2;
        countX(arr, x);

    }

    private static void countX(int[] arr, int x) {
        int count = 0;
        int index = Arrays.binarySearch(arr, x);
        if (index != -1) {
            count++;
        }
        // Count elements on right side.
        int left = index - 1;
        while (left >= 0 && arr[left] == x) {
            count++;
            left--;
        }

        // Count elements on right side.
        int right = index + 1;
        while (right < arr.length && arr[right] == x) {
            count++;
            right++;
        }
        System.out.println(count);
    }

}
