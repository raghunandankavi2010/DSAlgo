package programs.projecteuler;

public class PrimeNumbers {

    public static void main(String[] args) {

        int i;
        int maxCheck = 100; // maxCheck limit till which you want to find prime numbers
        boolean isPrime;

        //Empty String
        StringBuilder primeNumbersFound = new StringBuilder();

        //Start loop 1 to maxCheck
        for (i = 1; i <= maxCheck; i++) {
            isPrime = CheckPrime(i);
            if (isPrime) {
                primeNumbersFound.append(i).append(" ");
            }
        }
        System.out.println("Prime numbers from 1 to " + maxCheck + " are:");
        // Print prime numbers from 1 to maxCheck
        System.out.println(primeNumbersFound);
    }

    private static boolean CheckPrime(int numberToCheck) {
        int remainder;
        // suppose you have 25. it is necessary to check only till 13
        // cause 13*2 = 26. That is why numberToCheck/2
        for (int i = 2; i <= numberToCheck / 2; i++) {
            remainder = numberToCheck % i;
            //if remainder is 0 than numberToCheckber is not prime and break loop. Elese continue loop
            if (remainder == 0) {
                return false;
            }
        }
        return true;

    }
}
