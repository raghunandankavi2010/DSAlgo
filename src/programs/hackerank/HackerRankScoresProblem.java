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
import java.util.List;

public class HackerRankScoresProblem {

    public static void main(String[] args){
        int[] arr = {3 ,4 ,21, 36, 10, 28, 35, 5, 24, 42};
        int n = arr.length;
        int lowestScore = arr[0];
        int highestScore = arr[0];
        List<Integer> minRecord = new ArrayList<Integer>();
        List<Integer> maxRecord = new ArrayList<Integer>();
        for(int i=1;i<n;i++){
            if(arr[i]<lowestScore){
                lowestScore = Math.min(lowestScore,arr[i]);
                minRecord.add(i);
            }  if(arr[i]>highestScore){
                highestScore = Math.max(lowestScore,arr[i]);
                maxRecord.add(i);
            }
        }
        System.out.println(minRecord.size()+" "+maxRecord.size());
    }
}
