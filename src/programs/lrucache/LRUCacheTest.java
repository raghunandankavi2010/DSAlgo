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

package programs.lrucache;

import java.util.*;

public class LRUCacheTest {
    public static void main(String... args) {
        Map<Integer, String> cache = new LRUCache<>(5);

        for (int i = 0; i < 5; i++) {
            cache.put(i, "hi");
        }
        cache.put(6,"hi");
        cache.put(7,"hi");

        printCache(cache);

        String two = cache.get(2);

        System.out.println("Two....."+two);

        printCache(cache);

        cache.put(8,"hi");
        System.out.println(".........................");

        printCache(cache);



//
//        Map.Entry<Integer, String> next = it.next();
//        System.out.println("Item : "+next.getKey()+" Deleted : "+cache.remove(next.getKey()));
    }

    private static void printCache(Map<Integer, String> cache) {
        Iterator<Map.Entry<Integer, String>> it = cache.entrySet().iterator();
        for (Map.Entry<Integer,String> entry : cache.entrySet())
            System.out.println("Key = " + entry.getKey() +
                    ", Value = " + entry.getValue());
    }

}
