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

//https://leetcode.com/problems/unique-paths/submissions/
public class UniquePathFromSrcToDes {

    public static void main(String[] args) {
        int c = 7;
        int r = 3;
        int uniquePaths = getUniquePath(c,r);
        System.out.println("Unique paths is "+uniquePaths);
    }

    // 1. initially 1st row and column is 1 unique paths
    // 2. for all the rest of the matrix it is dp[r-1][c] + dp[c-1] [r]
    // 3. result is dp[c-1][r-1]
    private static int getUniquePath(int c, int r) {
        int[][] dp = new int[r][c];

        for(int i=0;i<c;i++){
            dp[0][i] = 1;
        }

        for(int i=0;i<r;i++){
            dp[i][0] = 1;
        }

        for(int i=1;i<r;i++){
            for(int j=1;j<c;j++){
                dp[i][j]= dp[i-1][j]+dp[i][j-1];
            }
        }
      return dp[r-1][c-1];
    }
}
