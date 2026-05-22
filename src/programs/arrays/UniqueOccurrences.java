/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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
