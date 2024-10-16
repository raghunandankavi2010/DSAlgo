package programs.hackerank


fun main() {

    val mList: MutableList<Int> = mutableListOf()

    mList.add(5)
    mList.add(5)
    mList.add(3)
    mList.add(2)

    val result = listOfPiles(mList)
    println(result)
}

private fun listOfPiles(mList: MutableList<Int>): Int {
    var count = 0
    mList.sort()

    var prev: Int = mList[0]

    for (i in 1 until mList.size) {
        if (mList[i] > prev) {
            count++

            mList[i] = prev
            prev = mList[i]
        } else {
            prev = mList[i]
        }
    }
    return count
}
