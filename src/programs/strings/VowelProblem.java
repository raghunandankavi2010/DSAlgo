package programs.strings;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * "aieoueoaeeuioa",2
 * "ritikisagoodboy", 4
 */

public class VowelProblem {


    public static void main(String[] args) {
        String s =  "dsfffffffffffffhgfhgfffffffffafkdlsajfkjdkafjkdsjfkjdsayyyyyyyyyyyyyyyyyyysfdsfdsafdafdfndnfndfndnfndfndnfndfndnfndfndnfndnfndfdnfdfdfdfdfdfdf" +
                    "dfffffffffffffffffffgfhgffffffffslkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkalakidfuierofpefdmascvdjghfjhgjfsla;dgkakgkdgjkfjkgfkdajgkajkajkjkajgkdfkagkfdgkfgkfdk" +
                    "afdssssssssssssssssssssdfdssssssssssssssssssssssssssssskmjjjjjjjjjjjjasdfadsaaaaaaaaaaafhgfhaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" +
                    "asssssssssssssssssssssssssssswrerwrekjlkjlkjlkjlkjlkjljkljkljkljklkjljkljkljkljkljrertretertesssssfghfghssssssshfghgfssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss";
        System.out.println(Consonant(s, 4));

    }

    private static NavigableMap<String, Integer> map = new TreeMap<>();

    private static int Consonant(String input1, int input2) {
        return subString(input1, input1.length(), input2);
    }


    private static boolean isVowel(char c) {
        return (c == 'a' || c == 'e' || c == 'i' ||
                c == 'o' || c == 'u');
    }

    private static int longestVowel(String str) {
        int count = 0;
        char[] s = str.toCharArray();

        for (char c : s) {
            if (!isVowel(c)) {
                count++;
            }
        }

        return count;
    }

    private static int length = 0;
    private static int len;

    private static Integer subString(String str, int n, int vowel_length) {
        len = vowel_length;
        if (vowel_length > 0) {
            for (int i = len; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {

                    String substring = str.substring(i, j);
                    if (substring.length() >= vowel_length && substring.length() >= length && longestVowel(substring) >= vowel_length) {

                        // System.out.println(substring+" "+substring.length());
                        length = test(str, substring.length(), vowel_length);
                        if (check) {
                            return length;
                        } else {

                            len = length;

                        }
                    }

                }
            }

            return printMap(map);
        }
        return -1;


    }

    private static int max = 0;
    private static boolean check = false;

    public static Integer test(String s, int len, int vowel_length) {

        max = 0;

        Matcher m = Pattern.compile("([a-zA-Z]){" + len + "}").matcher(s);

        for (int i = 0; m.find(i); i = m.start() + 1) {
            if (longestVowel(m.group()) >= vowel_length) {
                max = len;
                map.put(m.group(), max);
                System.out.println(m.group() + " " + max);
                check = true;
            } else {
                System.out.println("Skip " + max);
                //map.values().removeAll(Collections.singleton(max));
                check = false;
                break;
            }
        }

        return max;

    }

    private static Integer printMap(NavigableMap<String, Integer> mp) {

        if (!mp.isEmpty()) {

            return mp.lastEntry().getValue();
        }
        return -1;
    }
}
