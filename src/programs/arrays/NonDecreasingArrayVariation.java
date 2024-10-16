package programs.arrays;

import java.util.Arrays;

/**
 * https://www.hackerrank.com/challenges/big-sorting/problem?h_r=next-challenge&h_v=zen
 */
public class NonDecreasingArrayVariation {


    // Complete the bigSorting function below.
    static String[] bigSorting(String[] unsorted) {

        // sorting hint taken from discussion section.
        Arrays.sort(unsorted, (x, y) -> {
            // If the length is not the same, we return the difference.
            // A negative # means, x Length is shorter, 0 means the same (this doesn't occur) and a postive # means Y is bigger
            if (x.length() != y.length()) return x.length() - y.length();

            // Now the length is the same.
            // Compare the number from the first digit.
            char[] xarray = x.toCharArray();
            char[] yarray = y.toCharArray();
            for (int i = 0; i < x.length(); i++) {
                char left = xarray[i];
                char right = yarray[i];
                if (left != right)
                    return left - right;
            }

            // Default: "0" means both numbers are the same.
            return 0;
        });
        return unsorted;

    }

    public static void main(String[] args)  {
        // reading values can be done through buffered reader
        // this prevented time out on a test case.
       String[] arr = {"31415926535897932384626433832795",
               "1",
               "3",
               "10",
               "3",
               "5"};
       String[] result = bigSorting(arr);
       for(String val: result){
           System.out.println(val);
       }
    }

}

