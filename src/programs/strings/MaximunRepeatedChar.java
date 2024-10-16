package programs.strings;

/**
 * Maximum occurring character in an input string
 */
public class MaximunRepeatedChar {

    public static void main(String[] args){
        String input = "aaankvdfda";
        int max = 0;
        char result = 0;
        int[] count = new int[256];
        for(int i=0;i<input.length();i++){
            count[input.charAt(i)]++;
            if (max < count[input.charAt(i)]) {
                max = count[input.charAt(i)];
                result = input.charAt(i);
            }
        }
        System.out.println(result+" "+max);
    }
}
