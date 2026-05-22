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

package programs.hackerank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompareTriplets {

    // Complete the compareTriplets function below.
    private static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int aCount=0;
        int bCount=0;
        if(a.size() == b.size()){
            for(int i=0;i<a.size();i++){
                if(a.get(i)>b.get(i)){
                    aCount++;
                }else if(a.get(i)<b.get(i)){
                    bCount++;
                }
            }
        }
        List<Integer> result = new ArrayList<>(aCount+bCount);
        result.add(aCount);
        result.add(bCount);
        return result;
    }

    public static void main(String[] args) {

       List<Integer> a = new ArrayList<>(Arrays.asList(17, 28, 30));
       List<Integer> b = new ArrayList<>(Arrays.asList(99, 16, 8));
       List<Integer> list = compareTriplets(a,b);
       for(Integer val: list){
           System.out.print(val+" ");
       }

    }
}