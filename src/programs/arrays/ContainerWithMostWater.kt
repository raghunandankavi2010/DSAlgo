package programs.arrays


fun main() {
    val height = intArrayOf(1,8,6,2,5,4,8,3,7)
    var low = 0
    var high = height.size -1
    var maxArea = 0
    while(low < high) {
        if(height[low] < height[high]) {
            maxArea = Math.max(maxArea,height[low] * (high - low))
            low ++
        } else {
            maxArea = Math.max(maxArea,height[high] * (high - low))
            high --
        }

    }

   println("Maximum water storage is $maxArea")
}