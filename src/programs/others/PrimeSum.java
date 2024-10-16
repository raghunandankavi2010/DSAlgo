package programs.others;

import java.util.*;

/**
 * Given an even number ( greater than 2 ), return two prime numbers whose sum will be equal to given number.
 * NOTE num solution will always exist. read Goldbach’s conjecture
 *
 * Example:
 * Input : 4
 * Output: 2 + 2 = 4
 *
 * If there are more than one solutions possible, return the lexicographically smaller solution.
 *
 *  If [a, b] is one solution with a <= b,
 *  and [c,d] is another solution with c <= d, then
 *
 *  [a, b] < [c, d]
 *
 *  If a < c OR a==c AND b < d.
 */

public class PrimeSum {
    private static ArrayList<Integer> primeSum(int num) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num < 2)
            return result;

        int first = 2;
        int second = num - first;
        while (first <= second) {
            second = num - first;
            System.out.printf("isPrime(%d) : %s \n ", second, isPrime(second));
            System.out.printf("isPrime(%d) : %s \n ", first, isPrime(first));
            if (isPrime(second) && isPrime(first)) {
                result.add(first);
                result.add(second);
                return result;
            }
            first++;
        }

        return result;
    }

    private static boolean isPrime(int n) {

        if (n == 2) return true;
        if (n % 2 == 0)
            return false;
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i < sqrt; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int num = 16;
        ArrayList<Integer> result = primeSum(num);
        System.out.println(result);
    }
}