package programs.hackerank;

import java.util.Scanner;

public class ClimbingLeaderBoard {

    // Complete the climbingLeaderboard function below.
    private static int[] climbingLeaderboard(int[] scores, int[] alice) {

        int[] rank = new int[scores.length];
        int[] res = new int[alice.length];
        rank[0] = 1;
        for (int i = 1; i < scores.length; i++) {

            if (scores[i] == scores[i - 1]) {
                rank[i] = rank[i - 1];
            } else {
                rank[i] = rank[i - 1] + 1;
            }
        }
        for (int i = 0; i < alice.length; i++) {
            if (alice[i] > scores[0]) {
                res[i] = 1;
            } else if (alice[i] < scores[scores.length - 1]) {
                res[i] = rank[scores.length - 1] + 1;
            } else {
                res[i] = rank[binarySearchCustom(scores, alice[i])];
            }

        }

        return res;
    }

    // modified to handle ksy between adjacent members
    private static int binarySearchCustom(int[] scores, int key) {
        int low = 0;
        int high = scores.length;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] == key) {
                return mid;
            } else if (scores[mid] < key && key < scores[mid - 1]) {// this is if key between mid and its lefts adjacent member
                return mid;
            } else if (scores[mid] > key && key >= scores[mid + 1]) {// this is if key between mid and its right adjacent member
                return mid + 1;
            } else if (scores[mid] < key) {
                high = mid - 1;
            } else if (scores[mid] > key) {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int scoresCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] scores = new int[scoresCount];

        String[] scoresItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < scoresCount; i++) {
            int scoresItem = Integer.parseInt(scoresItems[i]);
            scores[i] = scoresItem;
        }

        int aliceCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] alice = new int[aliceCount];

        String[] aliceItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < aliceCount; i++) {
            int aliceItem = Integer.parseInt(aliceItems[i]);
            alice[i] = aliceItem;
        }

        int[] result = climbingLeaderboard(scores, alice);

        for (int value : result) {
            System.out.println(value);
        }

        scanner.close();
    }
}

