package programs.others;

/**
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 * Hint : Not to convert int to String and also consider underflow and overflow cases
 */
public class PalindromeNumber {

    public static void main(String args[]){
        int x =  -1 ;
        boolean flag = false;
        if(x<0){
            flag = false;
        }else if(x<Integer.MIN_VALUE){
            flag = false;
        }else if(x>Integer.MAX_VALUE){
            flag = false;
        }else{
            int rev = reverse(x);
            if(x==rev){
                flag = true;
            }else{
                flag = false;
            }
        }
        if(flag){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }
    private static int reverse(int number){
        int rev=0;
        while(number!=0){
            int pop = number%10;
            number = number/10;
            rev = rev*10+pop;

        }
        return rev;
    }

}
