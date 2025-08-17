package programs.algoexpert

fun main() {
    val distances = listOf(10, 20, 10, 15, 5, 15, 25)
    val fuel = listOf(0, 2, 1, 0, 0, 1, 13)
    val mpg = 20
    println(validStartingCity(distances,fuel,mpg))
}


fun validStartingCity(distances: List<Int>, fuel: List<Int>, mpg: Int): Int {
    // Write your code here.
    var starting = 0
    var totalDiff = 0
    var tank = 0

    fuel.forEachIndexed { index, element ->
        totalDiff += element * mpg - distances[index]
        tank += element * mpg - distances[index]
        if(tank < 0 ) {
            starting  = index + 1
            tank = 0
        }
    }
    return if (totalDiff < 0) {
        -1
    } else {
        starting
    }

}

