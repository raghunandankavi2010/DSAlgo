package programs.matrix;

public class MatrixRotate {

    public static void main(String[] args) {
        int[][] mat = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        rotateMatrixAntiClockWise(mat);
        System.out.println();
        rotateMatrixClockWise(mat);
    }

    private static void rotateMatrixAntiClockWise(int[][] mat) {

        int n = 4;
        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < n - x - 1; y++) {
                int temp = mat[x][y];
                // move top right to top left
                mat[x][y] = mat[y][n - 1 - x];
                // move bottom right to top right
                mat[y][n - 1 - y] = mat[n - 1 - x][n - 1 - y];
                // move bottom left to bottom right;
                mat[n - 1 - x][n - 1 - y] = mat[n - 1 - y][x];
                // put temp to bottom left
                mat[n - 1 - y][x] = temp;

            }
        }
        displayMatrix(n, mat);
    }

    private static void rotateMatrixClockWise(int[][] mat) {

        int n = 4;
        for (int x = 0; x < n / 2; x++) {
            for (int y = x; y < n - x - 1; y++) {
                int temp = mat[x][y];
                // move bottom left to top left
                mat[x][y] = mat[n - 1 - y][x];
                // move bottom right to bottom left
                mat[n - 1 - y][x] = mat[n - 1 - x][n - 1 - y];
                // move top right to bottom right;
                mat[n - 1 - x][n - 1 - y] = mat[y][n - 1 - x];
                // put temp to bottom left
                mat[y][n - 1 - x] = temp;

            }
        }
        displayMatrix(n, mat);
    }

    private static void displayMatrix(int N, int[][] mat) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
