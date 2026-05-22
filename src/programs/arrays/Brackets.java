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

import java.util.Scanner;
import java.util.Stack;

public class Brackets {

    private int count = 0;

    public static void main(String[] args) {

        //Scanner
        Scanner s = new Scanner(System.in);
        String input = ")()()(";//s.nextLine();                 // Reading input from STDIN
        Brackets brackets = new Brackets();
        int count = brackets.getCount(input);
        System.out.println(count);
    }

    private int getCount(String input) {
        char[] chars = input.toCharArray();
        boolean chk = checkBracketCorrect(chars);
        if (chk) {
            count++;
        }

        int i=1;
        while(i<=input.length()-1) {
            chars = leftRotatebyOne(chars,chars.length);
            System.out.println(i+" rotation "+String.valueOf(chars));
            boolean chr = checkBracketCorrect(chars);
            if (chr) {
                count++;
            }
            i++;
        }
        return count;
    }

    private boolean checkBracketCorrect(char[] chars) {
        Stack<Character> stack = new Stack<Character>();
        for (char ch : chars) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if(!stack.isEmpty())
                stack.pop();
            }
        }
        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private char[] leftRotatebyOne(char[] arr, int n) {
        int i;
        char temp;
        temp = arr[0];
        for (i = 0; i < n - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[i] = temp;
        return arr;
    }
}
