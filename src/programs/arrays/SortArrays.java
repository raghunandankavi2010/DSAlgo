package programs.arrays;

/**
 * Given an array A[] consisting 0s, 1s and 2s.
 * The task is to write a function that sorts the given array.
 * The functions should put all 0s first, then all 1s and all 2s in last.
 * Input: {0, 1, 2, 0, 1, 2}
 * Output: {0, 0, 1, 1, 2, 2}
 */
public class SortArrays {

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        int[] sortedArray = insertionSort(arr);
        for (int num : sortedArray) {
            System.out.print(" " + num);
        }
        System.out.print(" ");
        int count_0 = 0;
        int count_1 = 0;
        int count_2 = 0;
        // count number of 0,1's and 2's
        for (int number : arr) {
            if (number == 0) {
                count_0++;
            } else if (number == 1) {
                count_1++;
            } else {
                count_2++;
            }
        }
        // iterate over the counts and
        // place 0 first and 1's next and 2's at last
        int index = 0;
        for (int i = 0; i < count_0; i++) {
            arr[i] = 0;
            index++;
        }

        for (int i = 0; i < count_1; i++) {
            arr[index] = 1;
            index++;
        }
        for (int i = 0; i < count_2; i++) {
            arr[index] = 2;
            index++;
        }
        for (int number : arr) {
            System.out.println(number);
        }
    }

    private static int[] insertionSort(int[] arr) {
        int j;

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}
