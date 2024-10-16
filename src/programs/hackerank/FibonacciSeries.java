package programs.hackerank;

public class FibonacciSeries {

    public static void main(String[] args){

        FibonacciSeries fibonacciSeries = new FibonacciSeries();
        int n = 9;
        int value = fibonacciSeries.fib(n);
        System.out.println(value);
        int[] fibs = fibonacciSeries.fib2(n);
        System.out.println("Fibonacci of nth number: "+fibs[n-1]);
        System.out.print("Fibonacci Sequence for 9 numbers: ");
        for(int number: fibs){
            System.out.print(number);
            System.out.print(" ");
        }

    }

    // recursive approach
    private int fib(int n){
        if ( n <= 2 )
            return 1;
        return (fib(n-1)+ fib(n-2));
    }

    // dynamic programming
    // if you already have calculated fib of any number
    // re-use it instead of repeating calculation
    private int[] fib2(int n){
        int[] fib = new int[n];
        fib[0] = 1;
        fib[1] = 1;
        for(int i=2;i<n;i++){
            fib[i] = fib[i-1] +fib[i-2];
        }
        return fib;
    }
}
