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

public class IsPrime {

    public static void main(String[] args) {
        int num = 15;
        System.out.println(" Number is prime or not "+isPrime(num));
    }

    /**
     *
     * @param num - a positive integer
     * @return true if its prime else false
     * if you need to check 13 is prime or not
     * you need to check till 6 because 6*2 = 12.
     */
    private static boolean isPrime(int num){
        for(int i=2;i<=(num/2);i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
