package programs.arrays;

/** Leet code problem
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 *
 * Example 1:
 *
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * Example 2:
 *
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 */
public class FindIndex {

    public static void main(String[] args){
        int[] arr = {5,7,7,8,9,10};
        int target = 8;
        int[] output = findStartEndIndex(arr,target);
        for(int number:output){
            System.out.println(number+" ");
        }
    }

    private static int[] findStartEndIndex(int[] arr, int target) {
        int[] output = new int[2];
        int low = 0;
        int high = arr.length-1;
        int indexMid = binarySearch(arr,low,high,target);
        int startIndex = indexMid;
        int endIndex = indexMid;
        while(startIndex>low){
            if(arr[startIndex-1]==target){
                startIndex--;
            }else{
                break;
            }
        }
        while(endIndex<high){
            if(arr[endIndex+1]==target){
                endIndex++;
            }else{
                break;
            }
        }
        output[0] =startIndex;
        output[1]= endIndex;
        return output;
    }

    private static int binarySearch(int[] arr, int low, int high,int target) {
        int mid = (low+high)/2;
        if(low>high){
            return -1;
        }
        if(arr[mid] == target){
            return mid;
        }
        if(arr[mid]<target) {
            return binarySearch(arr, mid + 1, high, target);

        }else  {
            return binarySearch(arr,low,mid-1,target);
        }
    }
}
