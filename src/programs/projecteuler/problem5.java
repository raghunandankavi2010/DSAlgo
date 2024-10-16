package programs.projecteuler;

public class problem5 {

/**
 *  2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 */

    public static void main(String[] args) {
        find();
    }

    private static void find()  {
        long i=1;
        boolean check = false;
        while(i>=1) {
            for (int j = 1; j <= 20; j++) {
                if (i % j == 0) {
                    check = true;
                } else {
                    check = false;
                    break;

                }
            }
            if(!check)
            i++;
            else
            break;
        }
            if(check){
                System.out.println("Smallest positive number divisible by numbers 1 to 10 is "+i);
            }

    }
}
