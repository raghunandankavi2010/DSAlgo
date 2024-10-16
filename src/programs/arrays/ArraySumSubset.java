package programs.arrays;


import java.util.ArrayList;
import java.util.List;

/**
 * int[] arr = {2,4,6,10,11};
 * int sum = 13;
 * There is only 1 subset that adds up to 13 ie 2 and 11
 */
public class ArraySumSubset {

    private static int getmNumberOfSubsets(int[] numbers, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        int currentSum =0;
        for (int i = 0; i < numbers.length; i++) {
            currentSum += numbers[i];
            for (int j = Math.min(sum, currentSum); j >= numbers[i]; j--) {
                dp[j] += dp[j - numbers[i]];
               // System.out.print(j+" "+"dp[j]: "+dp[j]+" ");
            }
            //System.out.println();
        }
        return dp[sum];
    }

    public static boolean subsetSum(int input[], int total) {

        boolean T[][] = new boolean[input.length + 1][total + 1];
        for (int i = 0; i <= input.length; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= input.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j - input[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - input[i - 1]];
                } else {
                    T[i][j] = T[i-1][j];
                }
            }
        }

        return T[input.length][total];

    }

    public static int countSubsetsWithSumEqualToGivenSum(int[] arr, int sum) {
        if(arr.length == 0 || sum <= 0) {
            return 0;
        }

        int n = arr.length;

        int[][] count = new int[n][sum + 1];

        for(int i = 0; i < n; i++) {
            count[i][0] = 1;
        }

        for(int j = 0; j <= sum; j++) {
            if(arr[0] == j) {
                count[0][j] = 1;
            }
        }

        for(int i = 1; i < n; i++) {
            for(int j = 1; j <= sum; j++) {

                int includingCurrentValue = 0;
                int excludingCurrentValue = 0;

                if(arr[i] <= j) {
                    includingCurrentValue = count[i - 1][j - arr[i]];
                }

                excludingCurrentValue = count[i - 1][j];

                count[i][j] = includingCurrentValue + excludingCurrentValue;
            }
        }

        return count[n - 1][sum];
    }

    public static void main(String[] args){
        int[] arr = {2,4,6,10,11};
        int sum = 16;
        System.out.println(subsetSum(arr,sum));
    }
}
