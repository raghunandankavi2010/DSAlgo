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

package programs.matrix;

/**https://leetcode.com/contest/weekly-contest-162/problems/cells-with-odd-values-in-a-matrix/
 * Input: n = 2, m = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]]
 * [0 0 0]
 * [0 0 0]
 * 1252. Cells with Odd Values in a Matrix
 */
public class OddCellsmatrix {

    public static void main(String[] args) {
        int n=2;
        int m=3;
        int[][] matrix =new int[n][m];
        int[][] indices = {
                {0, 1},
                {1,1}
        };

        for (int[] index : indices) {
            for (int j = 0; j < index.length; j++) {
                if (j == 1) {
                    addMatrixColumn(index[j], matrix);
                } else {
                    addMatrixRow(index[j], matrix);
                }
            }
        }

        printMatrix(matrix);

   }

    private static void addMatrixRow(int row, int[][] matrix) {
        for(int i=0;i<matrix[0].length;i++){
            matrix[row][i] = matrix[row][i]+1;
        }
    }

    private static void addMatrixColumn(int column, int[][] matrix) {
        for(int i=0;i<matrix.length;i++){
            matrix[i][column] = matrix[i][column]+1;
        }
    }

    private static void printMatrix(int[][] matrix){
        int count =0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt % 2 != 0) {
                    count++;
                }
            }
        }
        System.out.println("Odd count of cells is "+count);
    }
}
