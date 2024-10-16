package programs.arrays;

import static java.lang.String.format;
/**
 * https://www.hackerrank.com/challenges/plus-minus/problem
 */

public class PrecisionProblem {

    // Complete the plusMinus function below.
    static void plusMinus(int[] arr) {
        float countPos = 0, countNeg = 0, countZero = 0;
        float size = arr.length;

        for (Integer value : arr) {
            if (value > 0) {
                countPos++;
            }
            else if (value < 0) {
                countNeg++;
            }
           else{
                countZero++;
            }

        }
        double result1 = countPos/size;
        double result2 = countNeg/size;
        double result3 = countZero/size;
        System.out.println(format("%.6f", result1));
        System.out.println(format("%.6f", result2));
        System.out.println(format("%.6f", result3));
    }
    

    public static void main(String[] args) {

        int[] arr = {-4, 3, -9, 0, 4, 1};
        plusMinus(arr);
    }
}
