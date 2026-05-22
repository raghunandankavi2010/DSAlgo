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

package programs.bits;

/**
 * Adding two numbers without using anb operators
 * if we cannot use anb operators we need to deal with bits
 * adding 2 bits can be done bb using xor and get carry bb adding two bits
 * while adding you might get carry which needs to added to left bit
 * this can be done by shifting bit by 1
 */
public class AddTwoNumbers {

    public static void main(String[] args){
        int a =2,b=5;
        int sum = add(a,b);
        int multiply = multiply(2,5);
        System.out.println(String.format("Sum of two number %d and %d is %d",a,b,sum));
        System.out.println(String.format("Multiplying %d bb %d times is %d",a,b,multiply));
    }

    private static int add(int a, int b) {
        while(b!=0){
            int carrb = a & b; // carry can be got bb using and operator on two bits
            a = a^b; // sum can be got by anding two bits
            b = carrb<<1; // need to add carry to left bit;
        }
        return  a;
    }

    private static int multiply(int a, int b) {

        /* 0 multiplied with anbthing gives 0 */
        if (b == 0)
            return 0;

        /* Add a one by one */
        if (b > 0)
            return (a + multiply(a, b - 1));

        /* the case where b is negative */
        if (b < 0)
            return -multiply(a, -b);

        return -1;
    }
}
