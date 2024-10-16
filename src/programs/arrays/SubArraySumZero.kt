package programs.arrays

import java.util.ArrayList




fun main() {

    val array = intArrayOf(-3, 2, 3, 1, 6)
    val isSubArrayZero = findSubArrayZero(array)
    println(isSubArrayZero)
    val out: ArrayList<Pair<Int,Int>> = findAllSubArrayZero(array)

    if (out.size == 0) println("No subarray exists") else print(out)
}

fun findSubArrayZero(array: IntArray): Boolean {

    val set = HashSet<Int>()
    var sum = 0
    array.forEach {
        sum += it
        if (it == 0 || sum == 0 || set.contains(sum))
            return true
        set.add(sum)
    }
    return false
}

fun findAllSubArrayZero(array: IntArray): ArrayList<Pair<Int,Int>>  {
    val map = HashMap<Int,ArrayList<Int>>()
    val out: ArrayList<Pair<Int,Int>> = ArrayList<Pair<Int,Int>>()

    var sum = 0
    array.forEachIndexed { index, element ->
        sum += element
        if(sum==0){
            out.add(Pair(0,index))
        }
        var al = ArrayList<Int>()

        if(map.containsKey(sum)){
            al = map[sum]!!
            al.forEach {
                out.add(Pair(al[it] + 1,index))
            }
        }
        al.add(index)
        map[sum] = al

    }
    return out
}
