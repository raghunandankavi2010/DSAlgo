package programs.strings;

public class Pyramid {

    public static void main(String[] args) {

        Pyramid pyramid = new Pyramid();
        pyramid.pyramid1();

    }
    /*
       1
       3 1
       5 3
       7 5
       9 7
     */
    private void pyramid1() {
        int res = 1;
        for (int i = 1; i <= 5; ++i) {
            int j = 0;
            int colVal = res;
            while (j < i) {
                if(j >=1) {
                    colVal = colVal-2;
                }
                System.out.print(colVal + " ");
                j++;
            }
            res += 2;
            System.out.println();
        }

    }

    private void pyramid2() {
        int res = 1;
        int n = 5;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n-i; j++) {
                System.out.print(res+"     ");
                res += 1;
            }
            System.out.println(" ");
        }

    }
}
