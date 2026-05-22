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
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence. Your algorithm should run in O(n) complexity.
 */
public class UberProblem3 {
    private static int longCount = 0;
    public static void main(String[] args) {
        int[] arr = {5,3,20,1,2,3,4};
        int count = 0;
        for(int i=0; i<arr.length-1; i++){
                int j = i + 1;
                int first = arr[i];
                int second = arr[j];
                if(first+1 == second){
                    count++;
                }else{
                    count = 0;
                }
                longCount =  Math.max(longCount,count);

        }
        if(longCount!=0) {
            longCount = longCount + 1;
        }
        System.out.println(longCount);
    }
}
