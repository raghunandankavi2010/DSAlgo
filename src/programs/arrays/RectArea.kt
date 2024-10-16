package programs.arrays

import java.util.Stack

fun main(){
    val hist = intArrayOf(6, 2, 5, 4, 5, 1, 6)
    val maxArea = getArea(hist,hist.size)
    println(maxArea)
}

/**
 *  1. check if stack is empty or area is greater than current push to stack
 *  2. if it is less then calculate area by popping from top of stack
 *  3. do this till stack is empty - to calculate left over bars
 */
fun getArea(hist: IntArray, n: Int): Int {

    var top: Int
    val stack = Stack<Int>()
    var area: Int
    var maxArea = 0
    var i = 0

    while(i<n) {

        if(stack.isEmpty() || hist[stack.peek()]<= hist[i]) {
            stack.push(i++)
        }else {
            top = stack.peek()
            stack.pop()
            area = if(stack.isEmpty()){
                hist[top] * i
            }else {
                hist[top] * (i - stack.peek() - 1)
            }
            if(area > maxArea){
                maxArea = area
            }
        }
    }

    while(!stack.isEmpty()){
        top = stack.peek()
        stack.pop()
        area = if(stack.isEmpty()){
            hist[top] * i
        }else {
            hist[top] * (i - stack.peek() - 1)
        }
        if(area > maxArea){
            maxArea = area
        }
    }

    return maxArea
}
