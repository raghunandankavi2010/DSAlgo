package programs.strings

import java.util.*

/**
 * Given a Unix path, represented as a list of strings, return its resolved version.

In Unix, ".." means to go to the previous directory and "." means to stay on the current directory. By resolving, we mean to evaluate the two symbols so that we get the final directory we're currently in.

Constraints

n ≤ 100,000 where n is the length of path
Example 1
Input
path = ["usr", "..", "usr", ".", "local", "bin", "docker"]
Output
["usr", "local", "bin", "docker"]
Explanation
The input represents "/usr/../usr/./local/bin" which resolves to "/usr/local/bin/docker"
 */
fun main() {

    val path = arrayOf("usr", "..", "usr", ".", "local", "bin", "docker")
    val stack = Stack<String>()
    for (i in path.indices) {
        if (path[i] == "..") {
            if(!stack.empty()) {
                stack.pop()
            }
        } else if (path[i] == ".") {
            continue
        } else {
            stack.push(path[i])
        }
    }

    while (!stack.empty()) {
        println(stack.pop())
    }
}