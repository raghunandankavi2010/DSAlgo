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

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class AccessOrderTest {
    public static void main(String... args) {
        test(new LinkedHashMap<>()); //insertion order
        System.out.println();
        test(new LinkedHashMap<>(16, 0.75f, true)); //access order
        System.out.println();
        test(new TreeMap<>()); //sorted order
        System.out.println();
        test(new HashMap<>()); //undefined order
    }

    private static void test(Map<Integer, String> map) {
        System.out.println(map.getClass().getSimpleName());
        map.put(42, "Meaning");
        map.put(7, "Days Per Week");
        map.put(86400, "Seconds");
        map.put(1, "Highlander");

        System.out.println("map = " + map);
        System.out.println("map.get(7) = " + map.get(7));
        System.out.println("map = " + map);
    }
}
