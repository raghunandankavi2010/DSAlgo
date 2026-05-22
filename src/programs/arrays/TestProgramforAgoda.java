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
