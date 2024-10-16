package programs.projecteuler;

public class problem6 {

    /**
     * The sum of the squares of the first ten natural numbers is,
     * <p>
     * 12 + 22 + ... + 102 = 385
     * The square of the sum of the first ten natural numbers is,
     * <p>
     * (1 + 2 + ... + 10)2 = 552 = 3025
     * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.
     * <p>
     * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
     **/

    public static void main(String[] args) {
        find();
    }

    private static void find() {

        int sum1 = 0, sum2 = 0, diff = 0;
        for (int j = 1; j <= 100; j++) {

            sum1 = sum1 + (j * j);
        }

        for (int j = 1; j <= 100; j++) {

            sum2 = sum2 + (j);
        }
        sum2 = sum2 * sum2;
        diff = sum2 - sum1;
        System.out.println(diff);


    }
}

