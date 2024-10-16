package programs.hackerank;

public class RichieRichProblem {
    private static String richieRich(String s, int n, int k) {
        int lives = k;
        boolean[] mod = new boolean[n];
        char[] temp = s.toCharArray();

        for (int i = 0; i < n / 2; i++) {
            if (temp[i] != temp[n - i - 1]) { // need to change
                mod[i] = true;
                lives--; // since it needs to change k/lives decremented
            }
            if (temp[i] < temp[n - i - 1]) { // if left is less than right copy right value to left
                temp[i] = temp[n - i - 1];
            }
            else if (temp[i] > temp[n - i - 1]){ // if right is less than left copy left to right
                temp[n - i - 1] = temp[i];
            }
            if (lives < 0){  // check if there are any lives left
                return "-1";
            }
        }
        // change the string from left to right with max value till k;
        int j = 0;
        while ((lives > 0) && (j < n / 2)) {
            if (temp[j] != '9') {
                if (mod[j]) lives++; // prevent changing the element again
                if (lives > 1) { // if lives is 1 that means odd string length
                    temp[j] = '9';
                    temp[n - j - 1] = '9';
                    lives -= 2;
                }
            }
            j++;
        }
        // if the length of string is odd and lives greater than 0 make middle element 9
        if (n % 2 == 1) {
            if (lives > 0) temp[n / 2] = '9';
        }
        return String.copyValueOf(temp);
    }

    public static void main(String[] args) {
        int n = 5;

        int k = 1;

        String s = "12321";
        String result = richieRich(s, n, k);
        System.out.println(result);

    }
}