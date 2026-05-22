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

package programs.hackerank;

import java.io.IOException;
import java.util.Scanner;

public class InsertionSortAdvanced {

    // Complete the insertionSort function below.
    private static int insertionSort(int[] arr) {

        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // if all elements are less than key
            // move elements to left
            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j = j - 1;
                count ++;
            }
            // insert element at position
            arr[j + 1] = key;

        }
        return count;
    }


    public static void main(String[] args) {

        int[] arr = {2, 1 ,3 ,1 ,2};
        int result =insertionSort(arr);
        System.out.println("Result is " + result);

    }

}