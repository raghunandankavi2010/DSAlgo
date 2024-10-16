package programs.arrays;

public class ArraySubSetEqualToK {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 0, 1, 1, 0 };
        int n = arr.length;
        int k = 4;
        int subArrayCount = findLongeSubArrayEqualTok(arr,k);
        System.out.println(subArrayCount);
    }

    private static int findLongeSubArrayEqualTok(int[] arr, int k) {

        int maxCount=0;int count = 0;
        int sum=0;
        for(int i=0;i<arr.length;i++){

            if(sum+arr[i]<=k){
                sum += arr[i];
                count++;
            }else {
                sum = sum-arr[i-count]+arr[i];
            }
            maxCount = Math.max(count,maxCount);
        }
        return maxCount;
    }
}
