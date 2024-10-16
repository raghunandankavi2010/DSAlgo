package programs.hackerearth

import java.lang.StringBuilder

/**
 * Given MacOS
 * output mac_o_s
 * HackerEarth -> hacker_earth
 */
fun main(){

    val input = "MacOS"
    val output = convert(input)
    println(output)
}

fun convert(input: String): String {
    val sb = StringBuilder()
    for ((index, value) in input.withIndex()){
        if(Character.isLowerCase(value)){
            sb.append(value.toLowerCase())
        }else {
            if(index==0){
                sb.append(value.toLowerCase())
            }else {
                sb.append("_")
                sb.append(value.toLowerCase())
            }
        }
    }
    return sb.toString()
}