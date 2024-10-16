package programs.hackerank;

import java.io.IOException;
import java.util.Scanner;

public class CatAndMouse {

    // Complete the catAndMouse function below.
    private static String catAndMouse(int x, int y, int z) {
      int diff1 = Math.abs(x-z);
      int diff2 = Math.abs(y-z);
      if(diff1>diff2){
          return "Cat B";
      }else if(diff2>diff1){
          return "Cat A";

      } else {
          return "Mouse C";
      }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            System.out.println("Result is : "+result);
        }


        scanner.close();
    }
}
