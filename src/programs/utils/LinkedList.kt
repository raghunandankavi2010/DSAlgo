package programs.utils

open class LinkedList(var value: Int) {
    var next: LinkedList? = null
}

fun LinkedList?.printList() {
    val head = this
    if (head == null) {
        println("List is empty.")
        return
    }
    var current: LinkedList? = head
    val listStr = StringBuilder()
    while (current != null) {
        listStr.append("${current.value} -> ")
        current = current.next
    }
    listStr.append("null")
    println(listStr.toString())
}