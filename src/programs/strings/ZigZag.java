package programs.strings;

import java.util.*;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 *  P   A   H   N
 *  A P L S I I G
 *  Y   I   R
 *  And then read line by line: "PAHNAPLSIIGYIR"
 *
 *  Write the code that will take a string and make this conversion given a number of rows:
 *
 *  string convert(string s, int numRows);
 *  Example 1:
 *
 *  Input: s = "PAYPALISHIRING", numRows = 3
 *  Output: "PAHNAPLSIIGYIR"
 *  Example 2:
 *
 *  Input: s = "PAYPALISHIRING", numRows = 4
 *  Output: "PINALSIGYAHRPI"
 *  Explanation:
 *
 *  P     I    N
 *  A   L S  I G
 *  Y A   H R
 *  P     I
 *  Accepted Solution : https://leetcode.com/submissions/detail/277565793/
 */
public class ZigZag {

    public static void main(String[] args) {
        String input = "ABCD";
        int rows = 3;
        System.out.println(convert(input,rows));

        StringBuilder sb = new StringBuilder(input.length());

        HashMap<Integer, ArrayList<Character>> map = new HashMap<>(rows);
        for (int i = 0; i < rows; i++) {
            ArrayList<Character> arrayList = new ArrayList<>();
            map.put(i, arrayList);
        }

        int low = 0;
        int high = input.length();
        int i = low;
        while (low <= high-1 ) {
            // handle the case of zigzag
            if (i == rows) {
                i = i - 1;
               for (int k = i; k > 0; k--) {
                    i--;
                    if (i == 0 && low<=input.length() - 1) {
                        ArrayList<Character> list = map.get(i);
                        list.add(input.charAt(low));
                        i = i + 1;
                        break;
                    } else if(i > 0 && low<=input.length() - 1){
                        ArrayList<Character> list = map.get(i);
                        list.add(input.charAt(low));
                    }
                    low++;
                }
                low++;

            } else {
                if(rows==1){ // in case row is 1 just add all elements to list at index 0;
                    while (low <= input.length() - 1) {
                        ArrayList<Character> list = map.get(i);
                        list.add(input.charAt(low));
                        low++;
                    }
                }else {
                    while (i < rows && low <= input.length() - 1) { // add all elements to list from index 0 to rows -1
                        ArrayList<Character> list = map.get(i);
                        list.add(input.charAt(low));
                        i++;
                        low++;
                    }
                }

            }

        }

        for (int m = 0; m < rows; m++) {
            ArrayList<Character> list = map.get(m);
            for(Character chr:list){
                sb.append(chr);
            }
        }
        System.out.println(sb.toString());
    }

    private static String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
