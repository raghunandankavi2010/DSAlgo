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

package programs.leetcode

fun removeSubfolders(folder: Array<String>): List<String> {
    // Step 1: Sort folders lexicographically
    folder.sort()

    val result = mutableListOf<String>()

    // Step 2: Iterate through the sorted list
    for (f in folder) {
        // If the result is empty or the current folder is not a sub-folder of the last added folder
        if (result.isEmpty() || !f.startsWith(result.last() + "/")) {
            result.add(f)
        }
    }

    return result
}

// Example usage:
fun main() {
    val folder1 = arrayOf("/a", "/a/b", "/c/d", "/c/d/e", "/c/f")
    val folder2 = arrayOf("/a", "/a/b/c", "/a/b/d")
    val folder3 = arrayOf("/a/b/c", "/a/b/ca", "/a/b/d")

    println(removeSubfolders(folder1))  // Output: ["/a", "/c/d", "/c/f"]
    println(removeSubfolders(folder2))  // Output: ["/a"]
    println(removeSubfolders(folder3))  // Output: ["/a/b/c", "/a/b/ca", "/a/b/d"]
}
