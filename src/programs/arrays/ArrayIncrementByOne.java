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
 *  Given an array you need to increment the number by 1
 *  Input 1,3,2,4
 *  OutPut 1,3,2,5
 */
public class ArrayIncrementByOne {

    public static void main(String[] args){
        int[] arr = {1,9,9,9};
        int[] output = new int[arr.length];
        int carry =1;
        int sum;
        for(int i= arr.length-1;i>=0;i--) {
            sum = arr[i] + carry;
            if (sum == 10) carry = 1;
            else carry = 0;
            // if there is no carry just the number
            output[i] = sum % 10;
        }
        // Handle case when 999
        // create new array
        // initialize index to 0 to 1
        // the rest are 0 initialized by default
        if(carry ==1){
            output = new int[arr.length+1];
            output[0] = 1;
        }
        for(int number :output){
            System.out.print(number);
        }
    }
}
