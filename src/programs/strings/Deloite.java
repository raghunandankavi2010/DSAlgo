package programs.strings;

import java.util.HashMap;
import java.util.Map;

public class Deloite {

    public static void main(String[] args) {
        String s = "abbcc";
        char[] chars = s.toCharArray();

        Map<Character,Integer> map = new HashMap<Character,Integer>();

        for( Character ch : chars) {
            if(!map.containsKey(ch)) {
                map.put(ch,1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }
        }

        int count  = 1;
        int min = Integer.MAX_VALUE;
        Character character = null;
        Character secondCharacter = null;
        for(Map.Entry<Character,Integer> entry: map.entrySet()) {
            count = count * entry.getValue();
            if(entry.getValue() <= min) {
                secondCharacter = character;
                min = entry.getValue();
                character = entry.getKey();
            }
        }
        System.out.println(count);

      if(character != null && secondCharacter != null){
            s = s.replaceAll(Character.toString(secondCharacter),Character.toString(character));
        }

        Map<Character,Integer> map2 = new HashMap<Character,Integer>();
        char[] chars2 = s.toCharArray();
        for( Character ch : chars2) {
            if(!map2.containsKey(ch)) {
                map2.put(ch,1);
            } else {
                map2.put(ch, map2.get(ch) + 1);
            }
        }

        int count2 = 1;
        for(Map.Entry<Character,Integer> entry: map2.entrySet()) {
            count2 = count2 * entry.getValue();
        }


        System.out.println(count2- count);

    }
}
