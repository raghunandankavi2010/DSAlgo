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

package programs.projecteuler;

public class problem5 {

/**
 *  2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 *
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 */

    public static void main(String[] args) {
        find();
    }

    private static void find()  {
        long i=1;
        boolean check = false;
        while(i>=1) {
            for (int j = 1; j <= 20; j++) {
                if (i % j == 0) {
                    check = true;
                } else {
                    check = false;
                    break;

                }
            }
            if(!check)
            i++;
            else
            break;
        }
            if(check){
                System.out.println("Smallest positive number divisible by numbers 1 to 10 is "+i);
            }

    }
}
