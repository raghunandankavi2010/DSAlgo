package programs.arrays


fun main() {
    val listArray = arrayOf(0,1,0,0,1,1,0,1,0)
    var left = 0
    var right = listArray.size-1

   while(left<right) {
        if(left< right && listArray[left]==0){
            left++
        } else{
            while(listArray[right]!=0 && left<right){
                right--
            }
            val temp = listArray[left]
            listArray[left] = listArray[right]
            listArray[right] = temp
            left++
            right--
        }
    }

    listArray.forEach {
        println(it)
    }
}