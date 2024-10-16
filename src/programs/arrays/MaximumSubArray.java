package programs.arrays;


import kotlin.Pair;

/**
 * Find out the maximum sub-array of non negative numbers from an array.
 * A : [1, 2, 5, -7, 2, 3]
 * The two sub-arrays are [1, 2, 5] [2, 3].
 * The answer is [1, 2, 5] as its sum is larger than [2, 3]
 */

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 5, -7,-7,8,9};
        Pair<Integer,Integer> pair = findSubArray(arr);
        System.out.println("Positive Sub Array whose sum is greater");
        for(int i=pair.getFirst();i<pair.getSecond();i++){
            System.out.print(arr[i]+" ");
        }

    }

    // calculate sum of elements till you find the negative number
    // startIndex is set to 0 initially
    // endIndex after calculating sum is i
    // check if sum calculated is greater than previous sum calculated
    // if so startIndex is pointing of the sub array sum calculation
    // endIndex is again pointing to i
    private static Pair<Integer,Integer> findSubArray(int[] arr) {
        int n = arr.length;
        int startIndex = 0;
        int endIndex = 0;
        int sum = 0;
        int newSum = 0;
        int beginIndex;

        for (int i = 0; i < n; i++) {
            beginIndex = i;
            while (i < n && arr[i] >= 0) {
                sum = sum + arr[i];
                i++;
            }

            if (sum > newSum) {
                startIndex = beginIndex;
                endIndex = i;
                newSum = sum;
            }
            sum = 0;
        }

        System.out.println("Sum of sub array that is greater: "+newSum);
        return new Pair<>(startIndex,endIndex);
    }
}


