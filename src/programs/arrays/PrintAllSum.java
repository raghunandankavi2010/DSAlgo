package programs.arrays;

public class PrintAllSum {

    public static void main(String[] args){
        int sum = 5;
        int[] arr = new int[5];
        int index = 0;
        printSum(arr,index,sum,sum);
    }

    private static void printSum(int[] arr, int i, int sum, int sumLeft) {
        int prev_num = (i > 0) ? arr[i - 1] : 1;
        for (int k = prev_num; k <= sum ; k++) {
            // set next element of the array to k
            arr[i] = k;

            // recur with the sum left and next location in the array
            if (sumLeft > k) {
                printSum(arr, i + 1, sum, sumLeft - k);
            }

            // if sum is found
            if (sumLeft == k) {
                printArray(arr, i);
            }
        }
    }

    private static void printArray(int[] out, int n) {
        for (int i = 0; i <= n; i++) {
            System.out.printf("%d ", out[i]);
        }
        System.out.println();
    }
}
