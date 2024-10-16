package programs.strings;

import java.util.*;
import java.lang.*;

public class KthLargestOccuringChar {

    public static void main(String[] args) {
        String s = "eeeedccbaaa";
        // a-2,b-1,c-1,d-1,e-4
        // 4,2,1,1,1

        sort(s);
        System.out.println(".......................................");
        Map<Character, Integer> hm = new TreeMap<>();
        for (char cur: s.toCharArray()) {
            if (!hm.containsKey(cur)) {
                hm.put(cur, 1);
            } else {
                hm.put(cur, hm.get(cur) + 1);
            }
        }
        int key = 4;
        // another alternative using priority Queue but in case of character with same frequency the last
        // character will be printed
        PriorityQueue<CountCharacters> pq = new PriorityQueue<>(s.length(), (a, b) -> {
            return b.count - a.count; // in reverse
        });
        for (HashMap.Entry<Character, Integer> entry : hm.entrySet()) {
                pq.add(new CountCharacters(entry.getValue(), entry.getKey()));

        }
        for (int i = 0; i < key - 1; i++) {
            pq.remove();
        }
        if (!pq.isEmpty()) {
            System.out.println(pq.remove().character);
        } else {
            System.out.println(-1);
        }
        // end of solution using priority Queue
        // the trick is to sort based on key which i missed.
        // My Soluion
       /* Map<Character,Integer> sortedMap = sorted(hm);

            int d = 0;
            boolean found = false;
            for (Map.Entry<Character,Integer>entry : sortedMap.entrySet()) {
                Character x = entry.getKey();
                if (d == (key-1)) {
                    found = true;
                    System.out.println("Value"+entry.getValue()+" "+x);
                    break;
                }
                d++;
            }

            if(!found){
                System.out.println(-1);
            }
        // end of my solution
        // sorting based on key skipping those that are already there.
        TreeMap<Integer, Character> tm = new TreeMap<>();

        for (Map.Entry<Character, Integer> entry : hm.entrySet()) {
            int x = entry.getValue();
            char cur = entry.getKey();
            if (!tm.containsKey(x)) {
                tm.put(x, cur);
            } else {
                if (cur < tm.get(x))
                    tm.put(x, cur);
            }

        }

        int k = 1; // print the kth most frequent character. If there are multiple, print the one with lesser value
        int tar = tm.size() - k;
        if (tar < 0) System.out.println("-1");
        else {
            int d = 0;
            for (Map.Entry<Integer, Character> entry : tm.entrySet()) {

                int x = entry.getKey();
                char cur = entry.getValue();
                if (d++ == tar) {
                    System.out.println(cur);
                    break;
                }
            }

        }
*/
    }

    private static Map<Character, Integer> sorted(Map<Character, Integer> hm) {

        // Create a list from elements of HashMap
        List<Map.Entry<Character, Integer>> list =
                new LinkedList<>(hm.entrySet());

        // Sort the list
        list.sort((o1, o2) -> (o2.getValue()).compareTo(o1.getValue()));

        // put data from sorted list to hashmap
        HashMap<Character, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Character, Integer> aa : list) {
            // skip those keys which already in map to avoid duplicates.
            // Linked hash map to maintain insertion order
            if (!temp.containsValue(aa.getValue())) {
                temp.put(aa.getKey(), aa.getValue());
            }
        }
        return temp;
    }

    private static void sort(String name) {

        // tree map sorting based on key example
        TreeMap<Character, Integer> map = new TreeMap<>();
        char[] arr = name.toCharArray();
        for (char c : arr) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }
    }

}

class CountCharacters {
    int count;
    Character character;

    CountCharacters(int count, char ch) {
        this.count = count;
        this.character = ch;
    }
}