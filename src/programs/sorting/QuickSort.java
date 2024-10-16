package programs.sorting;

/**
 *  QuickSort O(nlogn)
 */
public class QuickSort  {

    public static void main(String[] args) {
        QuickSort sorter = new QuickSort();
        int[] test = { 3,4,5,7,1,9,2 };
        sorter.sort(test);
        sorter.printResult(test);

    }

    private int[] numbers;

    private void sort(int[] values) {
        // check for empty or null array
        if (values ==null || values.length==0){
            return;
        }
        this.numbers = values;
        int number = values.length;
        quicksort(0, number - 1);
    }

    private void quicksort(int low, int high) {
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high-low)/2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller than the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger than the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a value in the left list which is larger than
            // the pivot element and if we have found a value in the right list
            // which is smaller than the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(i, j);
                i++;
                j--;
            }
        }
        // Recursion
        if (low < j)
            // sort left part of array
            quicksort(low, j);
        if (i < high)
            // sort right part of array
            quicksort(i, high);
    }

    private void exchange(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private void printResult(int[] numbers) {
        for (int value : numbers) {
            System.out.print(value);
        }
        System.out.println();
    }
}