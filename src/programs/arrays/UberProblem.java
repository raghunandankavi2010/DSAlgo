package programs.arrays;

import java.util.Arrays;

/**
 * Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. (O(Log(N)))
 */

public class UberProblem {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3,4};
        int x = 2;
        countX(arr, x);

    }

    private static void countX(int[] arr, int x) {
        int count = 0;
        int index = Arrays.binarySearch(arr, x);
        if (index != -1) {
            count++;
        }
        // Count elements on right side.
        int left = index - 1;
        while (left >= 0 && arr[left] == x) {
            count++;
            left--;
        }

        // Count elements on right side.
        int right = index + 1;
        while (right < arr.length && arr[right] == x) {
            count++;
            right++;
        }
        System.out.println(count);
    }

}
