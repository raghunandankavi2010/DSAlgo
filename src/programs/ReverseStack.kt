package programs

import java.util.*

fun main() {
    val stack = Stack<Int>()
    stack.push(1)
    stack.push(2)
    stack.push(3)
    stack.push(4)
    stack.push(5)
    reverse(stack)
    stack.forEach {
        println(it)
    }
}

fun reverse(stack: Stack<Int>) {
    if(stack.isEmpty()) return
    val poppedItem = stack.pop()
    reverse(stack)
    insertBottom(stack,poppedItem)

}

fun insertBottom(stack: Stack<Int>, poppedItem: Int) {
    if(stack.isEmpty()) {
        stack.push(poppedItem)
    } else{
        val popItem = stack.pop()
        insertBottom(stack,poppedItem)
        stack.push(popItem)
    }

}
