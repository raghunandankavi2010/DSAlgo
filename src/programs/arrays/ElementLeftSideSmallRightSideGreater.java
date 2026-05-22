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

public class ElementLeftSideSmallRightSideGreater {

    public static void main(String[] args) {
        //int[] arr = {7, 14, 16, 18 };
        int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
        System.out.println(findElement(arr));

    }

    private static int findElement(int[] arr){
        int[] leftMax = new int[arr.length];
        leftMax[0] = Integer.MIN_VALUE;

        for(int i=1;i<arr.length;i++){
            leftMax[i] = Math.max(leftMax[i-1],arr[i-1]);
        }

        int rightMin = Integer.MAX_VALUE;

        for(int i =arr.length-1;i>=0;i--){

            if(leftMax[i]< arr[i] && rightMin>arr[i]){
                return arr[i];
            }
            rightMin = Math.min(rightMin,arr[i]);
        }
        return -1;
    }
}
