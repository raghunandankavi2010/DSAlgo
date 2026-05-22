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

import kotlin.math.abs

/**
 * Complete the 'gradingStudents' function below.
 *
 * The function is expected to return an INTEGER_ARRAY.
 * The function accepts INTEGER_ARRAY grades as parameter.
 * https://www.hackerrank.com/challenges/grading/problem
 */

fun gradingStudents(grades: Array<Int>): Array<Int> {
    // Write your code here
    for( i in grades.indices){
        val grade = closestMultipleUpperValue(grades[i])
        val diff = abs(grade-grades[i])
        if(diff<3 && grade>=40)
            grades[i] = grade
        else
            grades[i]= grades[i]

    }

    return grades
}

fun closestMultipleUpperValue(value: Int): Int{
    var num = value
     num += (5 - num % 5)
    return num
}

fun main() {

    val gradesCount = readLine()!!.trim().toInt()

    val grades = Array<Int>(gradesCount, { 0 })
    for (i in 0 until gradesCount) {
        val gradesItem = readLine()!!.trim().toInt()
        grades[i] = gradesItem
    }

    val result = gradingStudents(grades)

    println(result.joinToString("\n"))
}
