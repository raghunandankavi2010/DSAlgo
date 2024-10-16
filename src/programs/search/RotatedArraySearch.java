package programs.search;

/**
 * Search an element in a sorted and rotated array
 * 1. find the pivot element
 * 2. the pivot element is always greater than the right element to it.
 * 3. check if pivot index is the key return the index.
 * 4. if arr[0]<=key then search left part of array. low = 0, high = pivot-1
 * 5. else search right part of array, low = pivot+1, high = n-1
 * 6. the other case to handle is if array is not rotated then pivot is -1 so do normal binary search.
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
 * key = 3
 * Output : Found at index 8
 */
public class RotatedArraySearch {

    public static void main(String[] args) {
        int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        // 5< = 8
        // 8< 6
        int[] temp = {3, 1, 2};
        if (checkArrayRotation(temp)) {
            System.out.println("Array is not rotated");
        } else {
            System.out.println("Array rotated right");
        }
        int n = arr.length;
        int key = 2;
        int searchedElementIndex = search2(arr, 0, arr.length - 1, key);
        System.out.println("Searched Element is at index: " + searchedElementIndex);
    }


    /** Using one single binary search
     *  This i little trickier than finding the pivot.
     *
     */
    private static int search2(int[] arr, int low, int high, int target) {
        if (low > high) return -1;

        int mid = (low + high) / 2;
        // if middle element is equal to target return mid as index
        if (target == arr[mid]) return mid;
        // if arr[low] <= arr[mid]
        if (arr[low] <= arr[mid]) {
            // if target< low then move right
            // if target > mid then move right
            if (target > arr[mid] || target < arr[low]) {
                return search2(arr, mid + 1, high, target);
            } else {
                return search2(arr, low, mid - 1, target);
            }
        } else {
            if (target < arr[mid] || target > arr[high]) {
                return search2(arr, low, mid - 1, target);
            } else if (target > arr[mid] && target < arr[high]) {
                return search2(arr, mid + 1, high, target);
            }
        }
        return -1;
    }

    private static int search(int[] arr, int n, int key) {
        int pivot = findPivot(arr, 0, n - 1);

        if (pivot == -1) {
            // array not rotated
            return binarySearch(arr, 0, n - 1, key);
        }
        if (arr[pivot] == key) {
            return pivot;
        }
        if (arr[0] <= key) {
            return binarySearch(arr, 0, pivot - 1, key);
        }
        return binarySearch(arr, pivot + 1, n - 1, key);
    }

    private static int binarySearch(int[] arr, int low, int high, int key) {
        if (high < low)
            return -1;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), high, key);
        return binarySearch(arr, low, (mid - 1), key);
    }

    private static int findPivot(int[] arr, int low, int high) {
        // base cases
        if (high < low)
            return -1;
        if (high == low)
            return low;

        /* low + (high - low)/2; */
        int mid = (low + high) / 2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid - 1);
        if (arr[low] >= arr[mid])
            return findPivot(arr, low, mid - 1);
        return findPivot(arr, mid + 1, high);
    }

    // just a util function to check array rotation
    private static boolean checkArrayRotation(int[] arr) {
        return arr[0] < arr[arr.length - 1];
    }
}
