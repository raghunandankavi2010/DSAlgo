package programs.arrays;

/**
 *  Given an array you need to increment the number by 1
 *  Input 1,3,2,4
 *  OutPut 1,3,2,5
 */
public class ArrayIncrementByOne {

    public static void main(String[] args){
        int[] arr = {1,9,9,9};
        int[] output = new int[arr.length];
        int carry =1;
        int sum;
        for(int i= arr.length-1;i>=0;i--) {
            sum = arr[i] + carry;
            if (sum == 10) carry = 1;
            else carry = 0;
            // if there is no carry just the number
            output[i] = sum % 10;
        }
        // Handle case when 999
        // create new array
        // initialize index to 0 to 1
        // the rest are 0 initialized by default
        if(carry ==1){
            output = new int[arr.length+1];
            output[0] = 1;
        }
        for(int number :output){
            System.out.print(number);
        }
    }
}
