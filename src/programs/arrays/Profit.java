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

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/
 */
public class Profit {

    public static void main(String[] args) {
        int[] arr= {7,1,5,3,6,4};
        calculateProfit(arr);
    }

    private static int calculateProfit(int[] arr) {
        if(arr.length == 0) return 0;
        int maxP = 0, minS = arr[0];
        for(int p:arr){
            minS = Math.min(minS,p);
            maxP = Math.max(maxP,p-minS);
        }
        return maxP;

    }
}
