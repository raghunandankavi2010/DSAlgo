package programs.strings;

/**
 *  input = AAAABBCCAAA
 *  output = A4B2C3A3
 */
public class StringCompression {

    public static void main(String[] args) {
        String input = "AAAABBCCCAAA";
        StringCompression stringCompression = new StringCompression();
        String output = stringCompression.compress(input);
        System.out.println(output);
    }

    private String compress(String input) {
        StringBuilder output = new StringBuilder();
        int count = 1;
        int length = input.length();

        for(int i=0;i<length;i++){
            if(i==length-1){
                output.append(input.charAt(i));
                output.append(count);
                break;
            }else if(input.charAt(i)== input.charAt(i+1)){
                count++;
            }else{
                output.append(input.charAt(i));
                output.append(count);
                count = 1;
            }
        }
        return output.toString();
    }

}
