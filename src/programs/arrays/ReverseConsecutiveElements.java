package programs.arrays;

import java.util.Arrays;

/**
 * Reverse an consecutive m elements given beg and end index
 * if i=1 and end = 5
 * m = 3
 * swap(arr[i],arr[i+m-1] ie swap(arr[1],arr[3]);
 *  1, 4, 3, 2, 5, 6, 7, 8, 9, 10
 *  now i =i+m = 1+3 = 4
 *  4+3-1<=5
 *  6<==5 false
 *  final output
 *  1, 4, 3, 2, 5, 6, 7, 8, 9, 10
 */
public class ReverseConsecutiveElements {

    public static void main(String[] args){
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int m = 3;
        int beg = 1, end = 5;
        reverse(arr,beg,Math.min(end,arr.length-1),m);
        System.out.println(Arrays.toString(arr));
    }
    // Function to reverse every consecutive m elements of
    // the sub-array arr[beg, end]
    private static void reverse(int[] A, int beg, int end, int m) {
        // return if sub-array length is less than m
        if (m > end - beg + 1) {
            return;
        }

        // reverse every consecutive m elements
        for (int i = beg; i <= end; i = i + m) {
            // check if sub-array length is atleast m
            if (i + m - 1 <= end) {
                reverse(A, i, i + m - 1);
            }
        }
    }

    private static int[] reverse (int[] A, int i, int j) {
        if (i >= j) {
            return A;
        }

        // else swap two elements
        swap(A, i, j);

        // recur for next pair
        return reverse(A, i + 1, j - 1);
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
