package programs.arrays


fun main(){
    val array = intArrayOf(1, 3, 5, 2, 1, 9, 3, 1, 1, 1)
    findDuplicates(array)
}

fun findDuplicates(array: IntArray) {

    val map: MutableMap<Int,Int> = mutableMapOf()

    array.forEach {
        if(!map.containsKey(it)){
            map[it] = 1
        }else{
            map[it] = map.getValue(it)+1
        }
    }

    val noDuplicates = map.filterValues { value -> value>1 }
    println(noDuplicates)
}
