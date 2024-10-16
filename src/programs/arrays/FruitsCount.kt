package programs.arrays

fun main() {
    val array = arrayOf(1,2,1)
    val output = totalFruit(array)
    println(output)
}

fun totalFruit(fruits: Array<Int>): Int {
    var lastFruit = -1
    var secondLastFruit = -1
    var lastFruitCount = 0
    var currMax = 0
    var max = 0

    fruits.forEach { fruit ->

        if(fruit == lastFruit || fruit == secondLastFruit){
            currMax += 1
        } else {
            currMax = lastFruitCount + 1
        }
        if(fruit == lastFruit){
            lastFruitCount += 1
        } else {
            lastFruitCount = 1
        }

        if(fruit != lastFruit) {
            secondLastFruit  = lastFruit
            lastFruit = fruit
        }

        max = Math.max(currMax,max)

    }
    return max

}