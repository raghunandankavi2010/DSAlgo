package programs.hackerank;

/**
 * https://www.hackerrank.com/challenges/staircase/problem
 * 6
 * Sample Output
 *
 *      #
 *     ##
 *    ###
 *   ####
 *  #####
 * ######
 */

public class Staircase {

    // Complete the staircase function below.
    private static void staircase(int n) {
        int count = 1;
        for (int i = 0; i <= n - 1; i++) {
            for (int j = 0; j <= n - 1 - (count); j++) {
                System.out.print(" ");
            }
            for (int k = 0; k < count; k++) {
                System.out.print("#");
            }
            count++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 6;
        staircase(n);
        System.out.println("Pyramid");
        printPyramid(n);
    }

    private static void printPyramid(int n){
        int i, space, rows, k=0;
        rows = n;
        for(i=1; i<=rows; i++) {
            for(space=1; space<=(rows-i); space++) {
                System.out.print("  ");
            }
            while(k != (2*i-1)) {
                System.out.print("# ");
                k++;
            }
            k = 0;
            System.out.println();
        }
    }
}