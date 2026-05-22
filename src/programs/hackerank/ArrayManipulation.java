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

/**
 * problem is similar to https://www.geeksforgeeks.org/constant-time-range-add-operation-array/
 * I actually used a brute force approach ended with 0(n2) two for loops but on hacker rank i got time out error
 * I looked at the discussion board and was able to get the below solution in o(n) which succeeded all test cases.
 */
public class ArrayManipulation {

    public static void main(String[] args) {
        int n = 5;
        int[][] queries = {
                {1, 2, 100},
                {2, 5, 100},
                {3, 4, 100}
        };
        System.out.println(arrayManipulation(n, queries));
    }

    // start index-1 initialized to sum end index initialized to -sum
    // start index =1 , end index =2 , sum =100
    // index 0 = 100; index 2 = -100. first iteration 100 0 -100 0 0
    // similarly index 1 =100, index does not exist ie 5>n. second iteration 100 100 -100 0 0
    // index 2 = 100 and index 4 = -100 . third iteration 100 100 0 0 -100.
    // adding all and taking max after each add is 200
    private static long arrayManipulation(int n, int[][] queries) {
        long[] initial = new long[n];
        long temp=0;
        long max = 0;
        for (int[] query : queries) {
            initial[query[0] - 1] += query[2];
            if (query[1] < n) initial[query[1]] -= query[2];
        }
        for(int i=0;i<n;i++){
            temp += initial[i];
            max = Math.max(temp,max);
        }
        return max;
    }
}
