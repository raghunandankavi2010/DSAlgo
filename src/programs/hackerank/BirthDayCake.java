package programs.hackerank;

import java.util.Scanner;

public class BirthDayCake {

    // Complete the birthdayCakeCandles function below.
    private static int birthdayCakeCandles(int[] ar) {

        int height = 0,count=0;
        for (int number : ar) {
            height = Math.max(number, height);
        }

        for (int number : ar) {
            if(number == height) {
                count++;
            }
        }
     return count;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {


        int arCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[arCount];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < arCount; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = birthdayCakeCandles(ar);
        System.out.println(result);

        scanner.close();
    }
}
