package programs.arrays;

/**
 * Sort a given array of 0's, 1's and 2's in linear time
 *
 */
public class SortArrays012 {

    public static void main(String[] args) {

        int[] arr = {1,0,0,0,2,1,2,2,1};
        int[] sortedArray = sortArray(arr);
        for(int num: sortedArray){
            System.out.print(num+" ");
        }
    }

    // 1 keep 3 pointers low = 0, high = arr.length-1 and mid =0
    // exchange arr[mid] and arr[low] if num is 0 increment mid and low
    // if num is 1 just increment mid pointer
    // exchange arr[high] and arr[mid] decrement high pointer.
    private static int[] sortArray(int[] arr) {
        int low = 0, mid = 0, high = arr.length-1;
        int temp;
        while(mid<=high){
            switch(arr[mid]){
                case 0:
                    temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                case 1:
                    mid++;
                    break;
                case 2:
                    temp = arr[high];
                    arr[high] = arr[mid];
                    arr[mid] = temp;
                    high--;
                    break;
            }
        }
        return arr;
    }
}
