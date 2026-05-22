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

import java.util.Scanner;

/**
 * Input:
 * s =HelloWorld
 * int start = 3
 * int end = 7
 * Output:
 * loWo
 */
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String S = in.next();
        int start = in.nextInt();
        int end = in.nextInt();

        // with substring
        // System.out.println(S.substring(start,end));

        // without substring
        int begin = 0;
        int ending = S.length()-1;
        for(int i=0;i<start;i++){
            begin = begin +1;
        }
        for(int i=S.length()-1;i>=end;i--){
            ending = ending -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=begin;i<=ending;i++){
        sb.append(S.charAt(i));
        }
        System.out.println(sb.toString());
    }
}
