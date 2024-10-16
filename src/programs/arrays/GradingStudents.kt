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
