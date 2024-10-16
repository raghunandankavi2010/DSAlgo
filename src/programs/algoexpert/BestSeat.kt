package programs.algoexpert

fun main() {
    val seats = mutableListOf(1)
    val result = bestSeat(seats)
    println(result)
}

fun bestSeat(seats: MutableList<Int>): Int {
    if(seats.isEmpty()) return -1
    var start = 0
    var end = 0
    var sIndex = -1
    var endIndex = -1
    var currLength = 0
    var maxLength = 0

    while (end < seats.size) {
        if (seats[end] == 0) {
            if (currLength == 0) {
                start = end
            }
            currLength++
        } else {
            if (currLength!= 0 && currLength > maxLength) {
                maxLength = currLength
                sIndex = start
                endIndex = end - 1
            }
            currLength = 0
        }
        end++
    }

    // Check the last segment
    if (currLength !=0 && currLength > maxLength) {
        sIndex = start
        endIndex = end - 1
    }

    // If two subarrays have the same length, choose the first one
    if (currLength !=0  && currLength == maxLength) {
        sIndex = start
        endIndex = end - 1
    }

    return if (sIndex == -1) -1 else (sIndex + endIndex) / 2
}
