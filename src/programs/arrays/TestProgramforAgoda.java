package programs.arrays;

import java.util.*;

public class TestProgramforAgoda {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(8,
                5,
                23,
                23,
                66,
                5,
                23,
                7,
                8);
        List<Integer> result = getFirstTwoItemsWithoutPair(list);
        for (Integer integer : result) {
            System.out.println(integer);
        }

    }
    public static List<Integer> getFirstTwoItemsWithoutPair(List<Integer> list) {
        List<Integer> mList = new ArrayList<>();
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        for (Integer integer : list) {
            if (!map.containsKey(integer)) {
                map.put(integer, 1);

            } else {
                map.put(integer, map.get(integer) + 1);
            }
        }
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if(index == 2){
                break;
            }
            else if (value == 1) {
                mList.add(key);
                index++;
            }
        }
        return mList;
    }
}
