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

package programs.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Given 10 Strings each of different length print
 * them in descending order
 */
public class SortListofStrings {

    public static void main(String[] args) {
        // Use LinkedList and you can sort while inserting
        // which is better cause ArrayList is backed by Array.
        // so when size increases it creates new array and copies old data
        // back to new array.
        List<String> mList = new ArrayList<>();
        String s = "a";
        for(int i=0;i<10;i++){
             s = s+i;
            mList.add(s);
        }
        mList.sort((o1, o2) -> o2.length()-o1.length());

        mList.forEach(System.out::println);
    }
}
