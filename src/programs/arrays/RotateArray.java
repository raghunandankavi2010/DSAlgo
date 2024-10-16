package programs.arrays;

public class RotateArray {

    public static void main(String[] args){
        int[] arr ={ 1,2,3,4,5};
        int times = 2;
        System.out.println("Left roated array 2 times");
        leftRotateNTimes(arr,times);
        System.out.println();
        System.out.println("Right Rotated array");
        printArray(rightRotate(arr));

    }

    private static void leftRotateNTimes(int[] arr, int n) {
        int[] rotatedArray = new int[arr.length];
        for(int i=0;i<=n-1;i++){
            rotatedArray = leftRotate(arr);
        }
        printArray(rotatedArray);
    }

    private static void printArray(int[] arr) {
        for(int number : arr){
            System.out.print(number+" ");
        }
    }

    private static int[] leftRotate(int[] arr) {
        int temp = arr[0];
        int i;
        for(i=0;i<arr.length-1;i++){
            arr[i] = arr[i+1];
        }
        arr[i] = temp;
        return arr;
    }

    private static int[] rightRotate(int[] arr) {
        int length = arr.length-1;
        int temp = arr[length];
        int i;
        for(i=length;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[i] = temp;
        return arr;
    }
}
