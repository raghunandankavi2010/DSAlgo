package programs.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * -9 -9 -9  1 1 1
 *  0 -9  0  4 3 2
 * -9 -9 -9  1 2 3
 *  0  0  8  6 6 0
 *  0  0  0 -2 0 0
 *  0  0  1  2 4 0
 *
 *  Pattern
 *  a b c
 *   d
 * e f g
 *
 * Sums of matrix elements in the above pattern
 *
 * -63, -34, -9, 12,
 * -10, 0, 28, 23,
 * -27, -11, -2, 10,
 * 9, 17, 25, 18
 *
 * Output : maximum of all the sum ie 28;
 */
public class MatrixSumHourGlass {

    public static void main(String[] args) {
        int[][] arr = {{-9, -9, -9, 1, 1, 1},
                {0, -9, 0, 4, 3, 2},
                {-9, -9, -9, 1, 2, 3},
                {0, 0, 8, 6, 6, 0},
                {0, 0, 0, -2, 0, 0},
                {0, 0, 1, 2, 4, 0}
        };
        List<Integer> mList = new ArrayList<>();
        //9 -9 -9 1 1 1 0 -9 0 4 3 2 -9 -9 -9 1 2 3 0 0 8 6 6 0
        // -->>4th line 0 0 0 -2 0 0 0 0 1 2 4 0
        //you can iterate till 4th line
        // because next iteration give 2 lines only
        // while you require 3 lines
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                mList.add((arr[i][j]+arr[i][j+1]+arr[i][j+2]+
                                  arr[i+1][j+1]+
                        arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2]));
            }
        }
        System.out.print(Collections.max(mList));
    }
}
