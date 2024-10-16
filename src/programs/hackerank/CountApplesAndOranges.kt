package programs.hackerank

import java.util.*

/**
 * https://www.hackerrank.com/challenges/apple-and-orange/problem
 */
// Complete the countApplesAndOranges function below.
fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>) {

    var count = 0
    for(i in apples.indices){
        val newDistance = apples[i]+a
        if(newDistance in s..t){
            count++
        }
    }
    println(count)

    count = 0
    for(i in oranges.indices){
        val newDistance = oranges[i]+b
        if(newDistance in s..t){
            count++
        }
    }
    println(count)

}

fun main() {
    val scan = Scanner(System.`in`)

    val st = scan.nextLine().split(" ")

    val s = st[0].trim().toInt()

    val t = st[1].trim().toInt()

    val ab = scan.nextLine().split(" ")

    val a = ab[0].trim().toInt()

    val b = ab[1].trim().toInt()

    val mn = scan.nextLine().split(" ")

    val m = mn[0].trim().toInt()

    val n = mn[1].trim().toInt()

    val apples = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    val oranges = scan.nextLine().split(" ").map{ it.trim().toInt() }.toTypedArray()

    countApplesAndOranges(s, t, a, b, apples, oranges)
}