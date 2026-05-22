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

public class MatrixRotate {

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotateMatrixAntiClockWise(mat);
        System.out.println();
        rotateMatrixClockWise(mat);
    }

    private static void rotateMatrixAntiClockWise(int[][] mat) {

        int n = 4;
        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < n - x - 1; y++) {
                int temp = mat[x][y];
                // move top right to top left
                mat[x][y] = mat[y][n - 1 - x];
                // move bottom right to top right
                mat[y][n - 1 - y] = mat[n - 1 - x][n - 1 - y];
                // move bottom left to bottom right;
                mat[n - 1 - x][n - 1 - y] = mat[n - 1 - y][x];
                // put temp to bottom left
                mat[n - 1 - y][x] = temp;

            }
        }
        displayMatrix(n, mat);
    }

    private static void rotateMatrixClockWise(int[][] mat) {

        int n = 4;
        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < n - x - 1; y++) {
                int temp = mat[x][y];
                // move bottom left to top left
                mat[x][y] = mat[n - 1 - y][x];
                // move bottom right to bottom left
                mat[n - 1 - y][x] = mat[n - 1 - x][n - 1 - y];
                // move top right to bottom right;
                mat[n - 1 - x][n - 1 - y] = mat[y][n - 1 - x];
                // put temp to bottom left
                mat[y][n - 1 - x] = temp;

            }
        }
        displayMatrix(n, mat);
    }

    private static void displayMatrix(int N, int[][] mat) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
