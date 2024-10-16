@file:Suppress("KotlinConstantConditions")

package programs.strings

fun main(){

    val str1 = "Raghu"
    val str2 = "Raghu"
    println(checkPermutation(str1,str2))

}

fun checkPermutation(str1: String,  str2: String): Boolean {
    var check = true
    val map = HashMap<Char,Int>()
    str1.forEach {

        if(!map.containsKey(it)) {
            map[it] = 1
        } else {
            map[it] = map.getOrDefault(it,-100) + 1
        }
    }

    str2.forEach {

        if(!map.containsKey(it)) {
            check = false
            return check
        } else {
            map[it] = map.getOrDefault(it,-100) - 1
        }
    }

    map.forEach { (key, value) ->

        if (value != 0) {
            check = false
            return check
        }

    }

    return check
}