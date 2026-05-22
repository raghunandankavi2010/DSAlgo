/*
 * Copyright 2026 Raghunandan Kavi
 *
 * Created by Raghunandan Kavi on 22 May 2026.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

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