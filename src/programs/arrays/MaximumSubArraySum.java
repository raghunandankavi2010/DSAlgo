package programs.arrays;

public class MaximumSubArraySum {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int sum = findSubArraySumMax(arr,0,arr.length-1);
        System.out.println("Max Sub Array sum: "+sum);
    }

    private static int findSubArraySumMax(int[] arr,int low, int high) {
        if (low == high)
            return arr[low];
        int mid = (low+high)/2;
        return  Math.max(Math.max(findSubArraySumMax(arr, low, mid),
                findSubArraySumMax(arr, mid+1, high)),
                maxSubArrayCrossingMid(arr, low, mid, high));
    }

    private static int maxSubArrayCrossingMid(int[] arr, int low, int mid, int high) {
        // Include elements on left of mid. 
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            sum = sum + arr[i];
            if (sum > leftSum)
                leftSum = sum;
        }

        // Include elements on right of mid 
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= high; i++) {
            sum = sum + arr[i];
            if (sum > rightSum)
                rightSum = sum;
        }

        // Return sum of elements on left 
        // and right of mid 
        return leftSum + rightSum;
    }
}
