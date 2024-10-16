package programs.leetcode


fun main() {
   val arr = intArrayOf(1,3,4,4)
   val result = twoSum(arr,8)
    result.forEach {
        println(it)
    }
}

private fun twoSum(numbers: IntArray, target: Int): IntArray {

    val array = intArrayOf(0,0)

    var s = 0
    var e = numbers.size -1
    while(s <= e) {
        val sum =  numbers[s] + numbers[e]
        if(sum > target) {
            e--
        } else if(sum < target) {
            s++
        } else if(s != e) {
            array[0] = (s + 1)
            array[1] = (e + 1)
            while(s < e && numbers[s] == numbers[s+1]) {
                s++
            }

            while(e > s && numbers[e] == numbers[e-1]) {
                e--
            }
            s++
            e--
        } else {
            s++
            e--
        }
    }

    return array
}