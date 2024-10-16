package programs.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://leetcode.com/problems/unique-number-of-occurrences/submissions/
 * Unique occurrences in array
 */
public class UniqueOccurrences {

    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        HashMap<Integer, Integer> valueMap = getValueMap(arr);
        System.out.println(hasAllUniqueCounts(valueMap));
    }

    private static  HashMap<Integer, Integer> getValueMap(int[] arr) {
        HashMap<Integer, Integer> valueMap = new HashMap<>(arr.length);
        for (int value : arr) {
            if (!valueMap.containsKey(value)) {
                valueMap.put(value,  1);
            } else {
                valueMap.put(value, valueMap.get(value) + 1);
            }
        }
        return valueMap;
    }

    private static boolean hasAllUniqueCounts(HashMap<Integer, Integer> valueMap) {
        List<Integer> values = new ArrayList<>(valueMap.size());
        for (Integer count : valueMap.values()) {
            if (values.contains(count)) {
                return false;
            }
            else {
                values.add(count);
            }
        }
        return true;
    }
}
