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
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.
 * <p>
 * You need to find the shortest such subarray and output its length.
 * <p>
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending
 */
public class ShortestNonContinuousSubArray {

    public static void main(String[] args) {

        int[] arr = {2, 1};
        ShortestNonContinuousSubArray shortestNonContinuousSubArray = new ShortestNonContinuousSubArray();
        System.out.println(shortestNonContinuousSubArray.findUnsortedSubarray(arr));
    }

    private int findSubArrayLength(int[] arr, int length) {
        int[] dup = Arrays.copyOf(arr, length);
        Arrays.sort(dup);
        int left = 0;
        int right = arr.length - 1;
        while (left < arr.length && arr[left] == dup[left]) {
            left++;
        }
        while (right > 0 && arr[right] == dup[right]) {
            right--;
        }

        if (right > left)
            return right - left + 1;
        return 0;
    }

    private int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = false;

        // find min
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1] && !flag) {
                min = Integer.min(nums[i], min);
                flag = true;
            }
            if (flag) {
                min = Integer.min(nums[i], min);
            }
        }
        // no min found. no need to find max
        if (!flag) {
            return 0;
        }
        // else find max now
        flag = false;
        // find max
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1] && !flag) {
                max = Integer.max(nums[i], max);
                flag = true;
            }
            if (flag) {
                max = Integer.max(nums[i], max);
            }
        }
        //Find correct position of min
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                min = i;
                break;
            }
        }
        //Find correct position of max
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max) {
                max = i;
                break;
            }
        }
        return max - min + 1;
    }
}
