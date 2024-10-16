package programs.arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
 */
public class Profit {

    public static void main(String[] args) {
        int[] arr= {7,1,5,3,6,4};
        calculateProfit(arr);
    }

    private static int calculateProfit(int[] arr) {
        if(arr.length == 0) return 0;
        int maxP = 0, minS = arr[0];
        for(int p:arr){
            minS = Math.min(minS,p);
            maxP = Math.max(maxP,p-minS);
        }
        return maxP;

    }
}
