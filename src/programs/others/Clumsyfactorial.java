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

package programs.others;

import java.util.ArrayList;
import java.util.List;

/**
 * Clumsy factorial my brute force approach
 * https://leetcode.com/submissions/detail/278740341/
 */
public class Clumsyfactorial {
    public static void main(String[] args){
        int n = 4;
        int output = clumsyOptimized(n);
        System.out.println(output);
    }

    private static int clumsyfactorial(int n) {

        int i = n;
        if(i==1){
            return 1;
        }
        List<Integer> skipped = new ArrayList<>();
        List<Integer> mul_div = new ArrayList<>();
        while (i > 0) {
            int res = 0;
            if(i==1){
                mul_div.add(i);
            }
            if (i > 1) {
                res = i * (i - 1);
                i = i - 2;
            }
            if (i > 1) {
                res = res / i;
                mul_div.add(res);
                i=i-1;

            } else if(res!=0) {
                mul_div.add(res);
            }
            if (!(i > 1)) {
                break;
            }else{
                skipped.add(i);
                i=i-1;
            }
        }
        int result = mul_div.get(0);
        if(mul_div.size()>1) {
            for (int j = 1; j < mul_div.size(); j++) {
              result = result -mul_div.get(j);
            }
        }
        for(int k=0;k<skipped.size();k++){
            result = result + skipped.get(k);
        }
        return result;
    }

    // i like this answer
    // if n<3 return n
    // answer = n*(n-1)/(n-2); lets take 12 12*11/10 = 13
    // now n becomes n -3; 12 - 3 = 9
    // while n>1 we need to add 9 so answer = answer+ n = 13+9 = 22
    // n = n-1; 9-1 = 8; answer = answer - n*n-1/n-2 = 22-8*7/6 = 22-9 = 13
    // repeat the above
    // to handle odd case  you have i/<3 (i calculated by i%4) just need to add 1 to answer in that case
    private static int clumsyOptimized(int n){
       if(n<3){
           return n;
       }
       int answer = n*(n-1)/(n-2);
       int i = n % 4;
       n -= 3;
       while(n>3){
           answer +=n--;
           answer = answer-(n*(n-1)/(n-2));
           n -= 3;
       }
       // handling odd number
        if (i < 3) {
            ++answer;
        }
     return answer;
    }

}
