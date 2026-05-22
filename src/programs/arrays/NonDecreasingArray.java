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


public class NonDecreasingArray {

    public static void main(String[] args) {
        NonDecreasingArray nonDecreasingArray = new NonDecreasingArray();
        int[] arr = {4,2};
        System.out.println(nonDecreasingArray.checkPossibility(arr));
    }

    private boolean checkPossibility(int[] nums) {
        int count = 0;
        int length = nums.length-1;
        for (int i = 0; i < length - 1 && count <= 1; ++i) {
            if (nums[i] > nums[i + 1]) { // e.g. [2,2,3,2,4] 3>2
                if (i > 0) {
                    if (nums[i - 1] <= nums[i + 1]) // if number is lesser or equal modify nums[i]
                        nums[i] = nums[i - 1];   // to the previous number. 2<=2 modify nums[i] =2
                    else                          // in all other cases modify the next number
                        nums[i + 1] = nums[i]; // to the current number to match// the sequence
                }
                ++count;
            }
        }

        return  count<=1;
    }
}
