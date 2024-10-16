package programs.matrix;

/**
 * Sub-matrix Sum using dynamic programming
 * Input : {
 *                 {1, 2, 3, 4, 6},
 *                 {5, 3, 8, 1, 2},
 *                 {4, 6, 7, 5, 5},
 *                 {2, 4, 8, 9, 4}
 *         };
 *  r1=2,c1=2,r2=3,c2=4;
 *  output: Sum of 7+5+5+8+9+4 = 38
 *  Explanation : https://www.youtube.com/watch?v=-d8KbQVx-mM
 */
public class SubMatrixSum {

    public static void main(String[] args) {
        int res;
        int[][] mat = {
                {1, 2, 3, 4, 6},
                {5, 3, 8, 1, 2},
                {4, 6, 7, 5, 5},
                {2, 4, 8, 9, 4}
        };

        int row = 4;
        int col = 5;
        int[][] dp = new int[row][col];
        dp[0][0] = mat[0][0];

        // process first row
        for(int i=1;i<col;i++){
            dp[0][i] = mat[0][i] + dp[0][i-1];
        }

        // process first column
        for(int i=1;i<row;i++){
            dp[i][0] = mat[i][0] + dp[i-1][0];
        }

        // process rest of the matrix
        for(int i=1;i<row;i++){
            for(int j=1;j<col;j++){
                dp[i][j] = mat[i][j] + dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1];
            }
        }


        int r1 = 2, c1 = 2, r2 = 3, c2 = 4;
        res = dp[r2][c2];

        // deduct column left
        if(c1>0){
            res -= dp[r2][c1-1];
        }

        //deduct row up
        if(r1>0){
            res -= dp[r1-1][c2];
        }

        // add the area that is deducted twice
        if(r1>0 && c1>0){
            res += dp[r1-1][c1-1];
        }

        System.out.println("Sum: "+res);
    }
}
