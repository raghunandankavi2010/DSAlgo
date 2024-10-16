package programs.sorting;

/**
 * Bubble Sort o(n)2
 * But in best case array is already sorted.
 * Requires ones pass. Hence the use of flag in the below code.
 */
public class BubbleSort {

    public static void main(String[] args){
        int[] arr= {23,1,49,100,5,3,6,21};
        int[] sortedArray = sort(arr);
        for(int number: sortedArray){
            System.out.println(number);
        }
    }

    private static int[] sort(int[] arr){
        int n = arr.length;
        // to check if array is already sorted
        boolean swap = false;
        for(int i=0;i<n-1;i++){
            // n-i-1 because you have the bigger element bubbled out.
            for(int j = 0;j< n-i-1;j++){
                if(arr[j]>=arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap = true;
                }
            }
            // check if no element bubble to the last position
            // this means that array is already sorted.
            // so no need fo further iteration return arr;
            if(!swap){
                return arr;
            }
        }
        return arr;
    }
}
