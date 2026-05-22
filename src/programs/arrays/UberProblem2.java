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
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
public class UberProblem2 {

    public static void main(String[] args){
        int r = 3;
        int c = 6;
        int[][] arr = { { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 } };
        printSpiral(r,c,arr);
    }

    private static void printSpiral(int r, int c, int[][] arr) {

        int i, k = 0, l = 0;
        while(k<r && l<r){
            // print first row
            for(i = l;i<c;i++){
                System.out.print(arr[k][i]+" ");
            }

            k++;
            // print last column row
            for(i = k;i<r;i++){
                System.out.print(arr[i][c-1]+" ");
            }
            c--;

            // print last row reverse
            if(k<r) {
                for (i = c - 1; i > 0; i--) {
                    System.out.print(arr[r - 1][i]+" ");
                }
                r--;
            }
            // Print the first column reverse
            if (l < c) {
                for (i = r - 1; i >= k; --i) {
                    System.out.print(arr[i][l]+" ");
                }

                l++;
            }
        }
    }
}


