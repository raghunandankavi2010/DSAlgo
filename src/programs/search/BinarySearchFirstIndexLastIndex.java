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

package programs.search;

import java.util.Arrays;

/**
 * LeetCode binary search variation problem
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 */
public class BinarySearchFirstIndexLastIndex {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int[] result = new int[2];
        int search = 2;
        BinarySearchFirstIndexLastIndex binarySearchFirstIndexLastIndex = new BinarySearchFirstIndexLastIndex();
        int first = binarySearchFirstIndexLastIndex.findfirstIndex(arr,search);
        int last = binarySearchFirstIndexLastIndex.findfirstIndex(arr,search+1)-1;
        if(first <= last){
            result[0] = first;
            result[1] = last;
        }else{
            result[0] = -1;
            result[1] = -1;
        }

        System.out.println(Arrays.toString(result));
    }

    private int findfirstIndex(int[] arr, int searchElement) {
        int firstPos = arr.length;
        int low = 0;
        int high = arr.length-1;
        while(high >= low) {
            int mid = low + (high - low) / 2;
            if (arr[mid]>=searchElement) {
                firstPos = mid;
                high = mid-1;
            } else  {
               low = mid+1;
            }
        }
        return firstPos;
    }
}
