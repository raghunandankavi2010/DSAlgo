package programs.projecteuler;

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * <p>
 * What is the 10 001st prime number?
 */

public class problem7 {

    public static void main(String[] args) {

        nthPrime(10001);
    }

    private static void nthPrime(int n) {
        int counter = 0;

        for(int i = 1; ; i++) {
            if(isPrime(i))
            counter++;

            if(counter == n) {
                System.out.println(i);
                break;
            }
        }
    }

    private static boolean isPrime(long n) {
        if(n < 2)
            return false;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
