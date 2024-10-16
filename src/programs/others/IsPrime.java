package programs.others;

public class IsPrime {

    public static void main(String[] args) {
        int num = 15;
        System.out.println(" Number is prime or not "+isPrime(num));
    }

    /**
     *
     * @param num - a positive integer
     * @return true if its prime else false
     * if you need to check 13 is prime or not
     * you need to check till 6 because 6*2 = 12.
     */
    private static boolean isPrime(int num){
        for(int i=2;i<=(num/2);i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
