package programs.arrays;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 */
public class UberProblem2 {

    public static void main(String[] args){
        int r = 3;
        int c = 6;
        int[][] arr = { { 1, 2, 3, 4, 5, 6 },
                { 7, 8, 9, 10, 11, 12 },
                { 13, 14, 15, 16, 17, 18 } };
        printSpiral(r,c,arr);
    }

    private static void printSpiral(int r, int c, int[][] arr) {

        int i, k = 0, l = 0;
        while(k<r && l<r){
            // print first row
            for(i = l;i<c;i++){
                System.out.print(arr[k][i]+" ");
            }

            k++;
            // print last column row
            for(i = k;i<r;i++){
                System.out.print(arr[i][c-1]+" ");
            }
            c--;

            // print last row reverse
            if(k<r) {
                for (i = c - 1; i > 0; i--) {
                    System.out.print(arr[r - 1][i]+" ");
                }
                r--;
            }
            // Print the first column reverse
            if (l < c) {
                for (i = r - 1; i >= k; --i) {
                    System.out.print(arr[i][l]+" ");
                }

                l++;
            }
        }
    }
}


