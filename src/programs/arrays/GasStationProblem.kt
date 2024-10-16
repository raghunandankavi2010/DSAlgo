package programs.arrays

fun main() {
    val gas = intArrayOf(1, 2, 3, 4, 5)

    val cost = intArrayOf(3, 4, 5, 1, 2)

    println("Gas station at index ${getGasStation(gas, cost)}")
}

/**
 *  if tank at any index is less than 0 this mean you can discard all index before this point
 *  this is hard to understand but we need to have more than couple of examples to figure this trick
 */

fun getGasStation(gas: IntArray, cost: IntArray): Int {

    var totalDiff = 0
    var starting = 0
    var tank = 0
    gas.forEachIndexed { index, element ->
        totalDiff += element - cost[index]
        tank +=  element - cost[index]
        if (tank < 0) {
            starting += 1
            tank = 0
        }

    }
    return if (totalDiff < 0) {
        -1
    } else {
        starting
    }

}
