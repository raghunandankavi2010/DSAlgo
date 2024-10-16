package programs.aoc;

public class aoc1 {

   public static void main(String[] args) {
        String input = "1111";
/*       int length = input.length();
        int sum = IntStream.range(0, length)
                .filter(i -> input.charAt(i) == input.charAt((i + 1) % length))
                .map(i -> Integer.parseInt(String.valueOf(input.charAt(i))))
                .sum();
        System.out.println(sum);*/

        int sum = 0;

        for (int i = 0; i < input.length() - 1; i++) {

            if (input.charAt(i) == input.charAt(i+1)) {
                sum += Integer.parseInt(String.valueOf(input.charAt(i)));
            }
            if (i + 2 == input.length() - 1) {
                if (input.charAt(i + 2) == input.charAt(0)) {
                    sum += Integer.parseInt(String.valueOf(input.charAt(i + 2)));
                }
            }
        }
        System.out.println(sum);

    }
  /*  int sum = 0;
    int half = input.length()/2;
        for (int i = 0; i < input.length() - 1; i++) {
        if(i+half<input.length())
            if (input.charAt(i) == input.charAt(i+half)) {
                sum += Integer.parseInt(String.valueOf(input.charAt(i)))+Integer.parseInt(String.valueOf(input.charAt(i+half)));
            }

    }
        System.out.println(sum);*/


}
