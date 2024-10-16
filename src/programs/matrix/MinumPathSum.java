package programs.matrix;


import java.util.ArrayList;
import java.util.List;

/**
 * Input:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */
public class MinumPathSum {

    //1. calculate sum of first row
    //2. calculate sum of first column
    //3. d[row] [column] = cost[row] [column] + min(dp[row][column-1]+dp[row-1][column]) starting from 2 row and column till end
    //4. dp[row] [column] will have the minimum cost to reach from left to right
     private int minCost(int[][] cost,int m,int n){

        int[][] dp = new int[m+1][n+1];
         List<Integer> mList = new ArrayList<>();
        int sum = 0;
        for(int i=0; i <= n; i++){
            dp[0][i] = sum + cost[0][i];
            sum = dp[0][i];
        }
        sum = 0;
        for(int i=0; i <= m; i++){
            dp[i][0] = sum + cost[i][0];
            sum = dp[i][0];
        }


        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                dp[i][j] = cost[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
         System.out.println("Dp array sum");
         for(int i=0; i <= m; i++){
             for(int j=0; j <= n; j++){
              System.out.print(dp[i][j]+" ");
             }
             System.out.println(" ");
         }


         mList.add(cost[m][n]);
         for(int i=m; i >=0 ; i--){
             for(int j=n; j >=0 ; j--){
                 if(i==0 || j==0){
                    break;
                 }
                 if(dp[j][j-1]<dp[j-1][j]){
                     mList.add(cost[j][j-1]);
                 }else{
                     mList.add(cost[i-1][i]);
                 }
             }
         }
         System.out.println("Path taken for minimum sum");
         for(int j= mList.size()-1;j>=0;j--){
             System.out.print(mList.get(j)+" ");
         }
         System.out.println("");
        return dp[m][n];
    }



    public static void main(String[] args){
        MinumPathSum mcp = new MinumPathSum();
        int[][] cost = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
                };
        int row = 2;
        int column = 2;
        int result = mcp.minCost(cost, row, column);
        System.out.println("Minimum cost: "+result);
    }
}
