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

import org.junit.Assert.assertArrayEquals
import org.junit.Test



class ArrayProblemTest {

     @Test
     fun testMethod1() {
         val arrayProblem = ArrayProblem()
         assertArrayEquals(arrayOf(1,2,7,8,9,0,0,0,0,0), arrayProblem.method1(arrayOf(1,2,0,7,0,8,0,0,0,9)))
     }

    @Test
    fun testMethod2() {
        val arrayProblem = ArrayProblem()
        assertArrayEquals(arrayOf(1,2,7,8,9,0,0,0,0,0), arrayProblem.method2(arrayOf(1,2,0,7,0,8,0,0,0,9)))
    }
 }