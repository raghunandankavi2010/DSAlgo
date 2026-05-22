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

/**
 * Sort a given array of 0's, 1's and 2's in linear time
 *
 */
public class SortArrays012 {

    public static void main(String[] args) {

        int[] arr = {1,0,0,0,2,1,2,2,1};
        int[] sortedArray = sortArray(arr);
        for(int num: sortedArray){
            System.out.print(num+" ");
        }
    }

    // 1 keep 3 pointers low = 0, high = arr.length-1 and mid =0
    // exchange arr[mid] and arr[low] if num is 0 increment mid and low
    // if num is 1 just increment mid pointer
    // exchange arr[high] and arr[mid] decrement high pointer.
    private static int[] sortArray(int[] arr) {
        int low = 0, mid = 0, high = arr.length-1;
        int temp;
        while(mid<=high){
            switch(arr[mid]){
                case 0:
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp;
                    high--;
                    break;
            }
        }
        return arr;
    }
}
