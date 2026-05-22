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
 * https://www.hackerrank.com/challenges/staircase/problem
 * 6
 * Sample Output
 *
 *      #
 *     ##
 *    ###
 *   ####
 *  #####
 * ######
 */

public class Staircase {

    // Complete the staircase function below.
    private static void staircase(int n) {
        int count = 1;
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= n - 1 - (count); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < count; k++) {
                System.out.print("#");
            }
            count++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 6;
        staircase(n);
        System.out.println("Pyramid");
        printPyramid(n);
    }

    private static void printPyramid(int n){
        int i, space, rows, k=0;
        rows = n;
        for(i=1; i<=rows; i++) {
            for(space=1; space<=(rows-i); space++) {
                System.out.print("  ");
            }
            while(k != (2*i-1)) {
                System.out.print("# ");
                k++;
            }
            k = 0;
            System.out.println();
        }
    }
}