package programs.hackerank;

import java.util.Arrays;

public class FindMedian {

    private static double findMedian(int[] arr) {
        Arrays.sort(arr);
        for (int number : arr) {
            System.out.print("" + number + " ");
        }
        int n = arr.length;
        double median;
        if (n % 2 == 0) {
            median = (double)(arr[(n-1)/2] + arr[n/2])/2.0;
        } else {
            median =  arr[n / 2];
        }

        return median;

    }

    public static void main(String[] args)  {
        int[] arr = {1,2,3,4,5,6};
        double result = findMedian(arr);
        double avg  = findAvg(arr);
        System.out.println("Median is :" + result);
        System.out.println("Avg is :" + avg);

    }

    private static double findAvg(int[] arr) {
        double sum=0;
        int n = arr.length;
        for (int number : arr) {
            sum += number;
        }
        return sum/n;
    }
}
