package programs.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the following details of a matrix with n columns and 2 rows :
 * <p>
 * The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
 * The sum of elements of the 0-th(upper) row is given as upper.
 * The sum of elements of the 1-st(lower) row is given as lower.
 * The sum of elements in the i-th column(0-indexed) is colsum[i], where colsum is given as an integer array with length n.
 * Your task is to reconstruct the matrix with upper, lower and colsum.
 * <p>
 * Return it as a 2-D integer array.
 * <p>
 * If there are more than one valid solution, any of them will be accepted.
 * <p>
 * If no valid solution exists, return an empty 2-D array.
 * Input: upper = 5, lower = 5, colsum = [2,1,2,0,1,0,1,2,0,1]
 * Output: [[1,1,1,0,1,0,0,1,0,0],[1,0,1,0,0,0,1,1,0,1]]
 */
public class Reconstruct2RowMatrix {

    public static void main(String[] args) {
        int upper = 5, lower = 5;
        int[] colsum1 = {2, 1, 2, 0, 1, 0, 1, 2, 0, 1};

        List<List<Integer>> mList = reconstructMatrix(upper, lower, colsum1);
        for (int i = 0; i < mList.size(); i++) {
            for (int j = 0; j < mList.get(i).size(); j++) {
                System.out.print(mList.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(colsum.length));
        matrix.add(new ArrayList<>(colsum.length));

        for (int j = 0; j < colsum.length; j++) {
            if (colsum[j] == 0) {
                matrix.get(0).add(0);
                matrix.get(1).add(0);
            } else if (colsum[j] == 2) {
                matrix.get(0).add(1);
                matrix.get(1).add(1);
                upper--;
                lower--;
            } else if (colsum[j] == 1) {
                if (upper > lower) {
                    matrix.get(0).add(1);
                    matrix.get(1).add(0);
                    upper--;
                } else {
                    matrix.get(0).add(0);
                    matrix.get(1).add(1);
                    lower--;
                }
            }
        }

        if (upper == 0 && lower == 0) return matrix;
        else return new ArrayList<>();
    }


}
//[[1,1,1,0,1,0,0,1,0,0],
// [1,0,1,0,0,0,1,1,0,1]]
//  2,1,2,0,1,0,1,2,0,1