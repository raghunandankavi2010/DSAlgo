package programs.projecteuler;

public class EvenFibonacciSeries {

    public static void main(String[] args) {

        int b = 2;
        int target = 4000000;

        int fib = 0;
        int res = 0;

        evenFibonacciSeries(b,fib,res);
        findSumOfEvenFibonnacciSeries(b, res,target);

    }

    private static void findSumOfEvenFibonnacciSeries(int b, int res, int target) {
        int sum = b;
        while(sum < target){
            int fib = b * 4 + res;
            sum = sum + fib;
            res = b;
            b = fib;
        }

        System.out.println("Sum of even fib series "+sum);
    }

    private static void evenFibonacciSeries(int b, int fib, int res) {
        int index = 3;
        while(index <= 6){
            fib = b*4+res;
            res = b;
            b = fib;
            index++;
        }
        System.out.println("6th even fib "+fib);
    }
}
