package programs.arrays;

/**
 * Problem https://leetcode.com/problems/greatest-sum-divisible-by-three/
 * Hint taken from
 * https://leetcode.com/problems/greatest-sum-divisible-by-three/discuss/431198/Python-DP-solution-beast-100-time-and-100-space
 */
public class SumDivisibleBy3 {
    public static void main(String[] args) {
        int[] arr = {3, 6, 5, 1, 8};
        int sum = maxSumDivThree(arr);
        System.out.println(sum);
    }

    //For example, the input is 3,6,5,1,8.
    // The initial dp would be
    //[[3,0,0],
    //[0,0,0],
    //[0,0,0],
    //[0,0,0],
    //[0,0,0]].
    //After the first iteration, which the ith value is 6. The f would become
    //[[3,0,0],
    //[9,0,0],
    //[0,0,0],
    //[0,0,0],
    //[0,0,0]].
    //After 2nd iteration, when ith value is 5, f becomes
    //[[3,0,0],
    //[9,0,0],
    //[9,0,14], (14 is from 9 + 5)
    //[0,0,0],
    //[0,0,0]].
    //Then, ith value is 1
    //[[3,0,0],
    //[9,0,0],
    //[9,0,14],
    //[15,10,14], (15 is from 14 + 1, 10 is from 9 + 1)
    //[0,0,0]].
    //And finally, ith value is 8
    //[[3,0,0],
    //[9,0,0],
    //[9,0,14],
    //[15,10,14],
    //[18,22,23]]. (18 is from 10 + 8, 22 is from 14 + 8, 23 is from 15 + 8)
    private static int calCulateSum(int[] arr) {
        int[][] dp = new int[arr.length][3];
        dp[0][arr[0] % 3] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < 3; j++) {
                int include = dp[i - 1][(j + 3 - arr[i] % 3) % 3] + arr[i];
                if (include % 3 == j) {
                    dp[i][j] = Math.max(dp[i - 1][j], include);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length - 1][0];
    }

    // Same as above but easier to understand
    private static int maxSumDivThree(int[] nums) {
        int N = nums.length;
        int[][] dp = new int[N][3];
        dp[0][nums[0] % 3] = nums[0];
        for (int i = 1; i < N; i++) {
            // copy from previous sum. maximum possible at current position
            for (int j = 0; j < 3; j++) {
                dp[i][j] = dp[i - 1][j];
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
            // calculate new sum
            for (int j = 0; j < 3; j++) {
                int s = dp[i - 1][j] + nums[i];
                dp[i][s % 3] = Math.max(s, dp[i][s % 3]);
                System.out.print(dp[i][s%3]);
            }
            System.out.println();
        }
        return dp[nums.length - 1][0];
    }
}
