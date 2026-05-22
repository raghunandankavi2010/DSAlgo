/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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

