package programs.hackerank;

import java.io.IOException;
import java.util.Scanner;

public class InsertionSortAdvanced {

    // Complete the insertionSort function below.
    private static int insertionSort(int[] arr) {

        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            // if all elements are less than key
            // move elements to left
            while (j >= 0 && arr[j] > key) {

                arr[j + 1] = arr[j];
                j = j - 1;
                count ++;
            }
            // insert element at position
            arr[j + 1] = key;

        }
        return count;
    }


    public static void main(String[] args) {

        int[] arr = {2, 1 ,3 ,1 ,2};
        int result =insertionSort(arr);
        System.out.println("Result is " + result);

    }

}