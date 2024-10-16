package programs.test;

public class Test {

    public static void main(String[] args){
        String s ="10,4,2";
        System.out.println(solution(s));

    }

    private static int solution(String s) {
        String[] array= s.split(",");
        int min=-1;
        int count =1;
        int diff;

            for (int i = 0; i <= array.length - 1; i++) {
                if (count <array.length) {
                    int start = Integer.parseInt(array[count]);
                    for (int j = 0; j <= count; j++) {
                        if (start != Integer.parseInt(array[j])) {
                            diff = start - Integer.parseInt(array[j]) ;
                            min = Math.max(diff,min);
                        }
                    }
                    count++;
                }
            }
        return min;
    }
}
