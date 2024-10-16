package programs.strings;

public class LowestCommonPrefix {

    public static void main(String[] args){
        String[] input = {"flower","flow","flight"};
        String output = longestCommonPrefix(input);
        System.out.println(output);
    }

    private static String longestCommonPrefix(String[] strs) {
        if ((strs == null) || (strs.length < 1)) {
            return "";
        }

        String shortestStr = strs[0];

        for (int j = 1; j < strs.length; j++) {
            if (strs[j].length() < shortestStr.length()) {
                shortestStr = strs[j];
            }
        }

        for (int j = 0; j < shortestStr.length(); j++) {
            char ch = shortestStr.charAt(j);
            for (int n = 0; n < strs.length; n++) {
                if (strs[n].charAt(j) != ch) {
                    return shortestStr.substring(0, j);
                }
            }
        }

        return shortestStr;
    }
}
