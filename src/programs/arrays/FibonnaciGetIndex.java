package programs.arrays;

public class FibonnaciGetIndex {

    public static void main(String[] args) {

        int a = 0;
        int b = 1;
        int c = 1;

        int n = 13;
        int index = 1;

        while(c<n) {
            c = a+b;
            index++;
            a = b;
            b = c;
        }

        System.out.println(index);
    }
}
