package programs.bits;



public class CountBits {

    // Function that count set bits
    private static int countSetBits(int n) {
        int count = 0;
        System.out.println(n);
        while (n != 0) {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    // Function that return count of
    // flipped number
    private static int FlippedCount(int a, int b) {
        // Return count of set bits in
        // a XOR b
        return countSetBits(a ^ b);
    }

    // Driver code
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.print(FlippedCount(a, b));
    }
}