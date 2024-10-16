package programs.arrays

/**
 * Given an array of integers, return a new
 * array such that each element at index i
 * of the new array is the product of all
 * the numbers in the original array except the one at i.
 * For example, if our input was [1, 2, 3, 4, 5],
 * the expected output would be [120, 60, 40, 30, 24].
 * If our input was [3, 2, 1], the expected output would be [2, 3, 6].
 */
fun main() {
    val array = intArrayOf(1, 2, 3, 4, 5)
    //findProductWithDivision(array)
    //val array1 = intArrayOf(1,2,0,5)
    //findProductsWithZeros(array1)
    withoutDivision(array)
}

private fun findProductWithDivision(array: IntArray) {
    val productArray = IntArray(array.size)
    var product = 1
    array.forEach {
        product *= it
    }

    for (i in array.indices) {
        productArray[i] = product / array[i]
    }

    productArray.forEach {
        println(it)
    }
}

private fun findProductsWithZeros(array: IntArray) {
    val productArray = IntArray(array.size) { 0 }
    var isZeros = false
    var countZeros = 0
    var product = 1
    array.forEach {
        if (it == 0) {
            isZeros = true
            countZeros++
        } else {
            product *= it
        }
    }

    if (countZeros <= 1) {
        if (!isZeros) {
            for (i in array.indices) {
                if (array[i] != 0)
                    productArray[i] = product / array[i]
            }
        } else {
            for (i in array.indices) {
                if (array[i] == 0) {
                    productArray[i] = product
                } else {
                    productArray[i] = 0
                }
            }
        }
    }

    productArray.forEach {
        println(it)
    }
}

private fun withoutDivision(array: IntArray) {
    val left = IntArray(array.size)
    val right = IntArray(array.size)
    val product = IntArray(array.size)

    left[0] = 1
    right[array.size - 1] = 1
    for (i in 1 until array.size) {
        left[i] = array[i - 1] * left[i - 1]
    }

    for (i in array.size - 2 downTo 0) {
        right[i] = array[i + 1] * right[i + 1]
    }

    for (i in array.indices) {
        product[i] = right[i] * left[i]
    }

    product.forEach {
        println(it)
    }

}
