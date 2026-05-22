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

package programs.arrays

/**
 *  Asked in Decathlon.
 */
class ArrayProblem {

    fun method1(inputArray: Array<Int>): Array<Int> {

        var count = 0
        // put all non zero elements to the start of array
        for (i in inputArray.indices) {
            if (inputArray[i] != 0) {
                inputArray[count] = inputArray[i]
                count++
            }
        }

        // from the first zero element to end of array
        // put zeros.
        while (count < inputArray.size)
            inputArray[count++] = 0
        return inputArray
    }

    fun method2(A: Array<Int>): Array<Int> {
        var j = 0
        // if its not zero  swap it with index which has zero
        // the start index for zero is tracked by j
        for (i in A.indices) {
            if (A[i] != 0) {
                val temp = A[i]
                A[i] = A[j]
                A[j] = temp
                j++
            }
        }

        return A
    }

    fun myMethod3(inputArray: Array<Int>): Array<Int> {
        var start = -1
        for( i in inputArray.indices) {
            if(inputArray[i] == 0 && start == -1) {
                start = i
            }

            if(inputArray[i]!=0 && start!=-1) {
                val temp = inputArray[i]
                inputArray[i] = inputArray[start]
                inputArray[start] = temp
                start += 1
            }
        }
        return inputArray
    }
}



fun main() {

    val arrayProblem = ArrayProblem()
    val inputArray = arrayOf(1, 2, 3, 0, 0, 4, 5, 0, 6, 0, 7, 8, 0, 0, 0, 9)

    val outputArray = arrayProblem.method1(inputArray)
    outputArray.forEach {
        print("$it ")
    }

    println("Swapping technique")

    val outputArray2 = arrayProblem.method2(inputArray)
    outputArray2.forEach {
        print("$it ")
    }
    println("\nThird Method")

    val outputArray3 = arrayProblem.myMethod3(inputArray)
    outputArray3.forEach {
        print("$it ")
    }


}

