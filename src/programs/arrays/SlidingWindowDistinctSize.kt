package programs.arrays

/**
 * Count Distinct Elements in every Window of size k in a given array
 * 1,2,2,1,3,1,1,3
 * 1,2,2,1 is of size k
 * distinct elements size is 2
 *
 */

fun main() {
    val array = intArrayOf(1,2,2,1,3,1,1,3)
    val k= 4
    val map = HashMap<Int, Int>()
    for(i in 0 until k){
        map[array[i]] = map.getOrDefault(array[i],0)+1
    }

    println(map.size)
    for(index in k until array.size){

        if(map[array[index-k]] == 1){
            map.remove(array[index-k])
        } else {
            val value = map[array[index-k]]?.minus(1)
            if(value != null) {
                map[array[index - k]] = value
            }
        }
        map[array[index]] = map.getOrDefault(array[index],0)+1
        println(map.size)
    }
}