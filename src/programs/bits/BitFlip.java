package programs.bits;

/**
 * Given a binary String which represents the target state.
 * Minimum number of flips needed to convert a same size Binary String (with all 0’s) to target state.
 * A flip also causes all the right bits to be flipped.
 * Input : 00101 (Represents Target)
 * Output : 3
 * Explanation :
 * 00000 -> 00111 -> 00100 -> 00101
 * Source Credit : https://stackoverflow.com/questions/58029234/given-a-binary-string-with-all-0s-covert-it-in-the-target-string
 * */
public class BitFlip {

    //bit = 00101
    //Result 0 */* 2 = 0. So 0^0(bit at 0) = 0
    //Result Count :0
    //Result 0 */* 2 = 0. So 0^0(bit at 1) = 0
    //Result Count :0
    //Result 0 */*2 = 0. So 0^1(bit at 2) = 1
    //Result Count :1
    //Result 1 */* 2 = 1. So 1^0(bit at 3) = 1
    //Result Count : (previous result = 1 +1) = 2
    //Result 2 */* 2 = 0. So 0^1(bit at 4) = 1
    //Result Count : (previous result = 2 + 1) = 3
    public static void main(String[] args){
        String output = "00101";
        char[] bits = output.toCharArray();
        int result = 0;
        for (char bit: bits){
            result += (result%2)^Integer.parseInt(Character.toString(bit));
        }
        System.out.println(result);
    }
}
