package programs.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Solution Credit : https://leetcode.com/articles/palindrome-permutation/
 * Strings with even characters count must have event count for characters
 * Strings with odd characters count must have one character with odd count
 */
public class PermutationOfAStringPalindrome {

    // Instead of hashmap use of array. similar to hashmap solution
    private static boolean canPermutePalindrome2(String s) {
        int[] map = new int[128];
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
        }
        int count = 0;
        for (int key = 0; key < map.length && count <= 1; key++) {
            count += map[key] % 2;
        }
        return count <= 1;
    }

    private static boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // put the char and the count as value
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (char key : map.keySet()) {
            count += map.get(key) % 2;
        }
        // count must be less than equal to 1
        // if its 2 palindrome not possible
        return count <= 1;
    }

    // One pass array solution
    private static boolean canPermutePalindrome3(String s) {
        int[] map = new int[128];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }

    // using set. I like this approach
    // add elements to set .
    // if a element exist is set remove it
    // check the size of set
    // size must be less than or equal to 1
    private static boolean canPermutePalindrome4(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            if (!set.add(s.charAt(i)))
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }


    public static void main(String[] args) {

        boolean check = canPermutePalindrome4("abab");
        if (check) {
            System.out.println("Palindrome Possible");
        } else {
            System.out.println("Palindrome Not Possible");
        }
    }

}
