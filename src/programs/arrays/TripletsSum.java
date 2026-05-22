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

public class TripletsSum {
    public static void main(String[] args) {

        int[] array =  {12, 3, 4, 1, 6, 9};
        int sum = 24;
        ArrayList<Integer> list = new ArrayList<>();

        for (int j : array) {
            list.add(j);
        }

        Collections.sort(list);
        boolean check = false;
        for(int i = 0;i<list.size();i++) {
            int value = list.get(i);
            int toFind = sum - value; // 7
            check = findTwoSum(list,toFind,value,i+1); //list ,7, start
            if(check){
                break;
            }
        }

        if(!check) {
            System.out.println("Triplets not found");
        }
    }

    private static boolean findTwoSum(ArrayList<Integer> list, int toFind, int value,int start) {

        int end = list.size()-1;

        boolean found = false;
        while(start < end) {
            int mysum = list.get(start)+list.get(end);
            if(mysum == toFind) {
                System.out.println(list.get(start) +" "+list.get(end)+ " "+value);
                found = true;
                break;
            } else if(mysum < toFind){
                start++;
            } else {
                end --;
            }
        }
        return found;
    }
}


