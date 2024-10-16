package programs.arrays

import kotlin.math.max

fun main() {

    val arrs = arrayOf(
        arrayOf(1,3),
        arrayOf(2,6),
        arrayOf(8,10),
        arrayOf(15,18)
    )

     merge(arrs)

}
fun merge(intervals: Array<Array<Int>>) {

    intervals.sortBy {
        it[0]
    }

    var index = 0
    for(i in 1 until intervals.size){
        if(intervals[index][1] > intervals[i][0]) {
            intervals[index][1] = max(intervals[index][1],intervals[i][1])
        } else {
            index ++
            intervals[index] = intervals[i]
        }
    }

  for(i in 0.. index) {
      intervals[i].forEach {element ->
          print("$element ")
      }
      println()
  }

}