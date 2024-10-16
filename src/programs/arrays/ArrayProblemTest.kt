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