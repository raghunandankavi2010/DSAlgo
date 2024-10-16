package programs.others;

public class ReverseInteger {

    public static void main(String[] args){
        int number = 1534236469;
        System.out.println(String.format("Reverse of %d is: %d",number,reverse(number)));
    }

    private static int reverse(int number){
       int rev=0;
        while(number!=0){
            int pop = number%10;
            number = number/10;
            // if rev is greater than Integer.MAX_VALUE/10 return 0. this is just to handle overflow
            // integer cannot hold large numbers.
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev*10+pop;

        }
        return rev;
    }
}
