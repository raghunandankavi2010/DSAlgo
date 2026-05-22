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

public class ArraySubSetEqualToK {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 0, 1, 1, 0 };
        int n = arr.length;
        int k = 4;
        int subArrayCount = findLongeSubArrayEqualTok(arr,k);
        System.out.println(subArrayCount);
    }

    private static int findLongeSubArrayEqualTok(int[] arr, int k) {

        int maxCount=0;int count = 0;
        int sum=0;
        for(int i=0;i<arr.length;i++){

            if(sum+arr[i]<=k){
                sum += arr[i];
                count++;
            }else {
                sum = sum-arr[i-count]+arr[i];
            }
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }
}
